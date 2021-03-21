# moliniao-spring-cloud
Spring-cloud版本Greenwich.SR4/2.1.4.RELEASE

Spring-boot版本2.1.10.RELEASE

Spring版本5.1.11.RELEASE

Java版本 1.8

Mybatis版本 3.5.3

# 更新.ignore文件
git rm -r --cached .

git add .

git commit

# eureka服务端配置
eureka:
  instance:
    hostname: localhost    #eureka服务端的实例名称
  client:
    register-with-eureka: false   #false表示不向注册中心注册自己
    fetch-registry: false         #false表示自己端就是注册中心，我的职责就是维护服务实例，并不需要去检索服务

方式1->OK service-url: 
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/    #设置与Eureka Server交互的地址查询服务和注册服务都需要依赖这个地址(单机) 

方式2->OK eureka-server-u-r-l-context: http://${eureka.instance.hostname}:${server.port}/eureka/    #设置与Eureka Server交互的地址查询服务和注册服务都需要依赖这个地址(单机)
    # defaultZone: http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/
    # host-info: eureka7001.com    #eureka服务端的实例名称

# eureka集群配置
1)域名映射: C:\Windows\System32\drivers\etc目录下hosts文件添加
127.0.0.1       eurekaone.com

127.0.0.1       eurekatwo.com

127.0.0.1       eurekathree.com

127.0.0.1       zuul.com

127.0.0.1       configclient.com

127.0.0.1       configserver.com


2)修改yml配置

eureka: 
  instance: 
    hostname: eurekaone.com
  client: 
    register-with-eureka: false
    fetch-registry: false
    eureka-server-u-r-l-context: http://eurekatwo.com:7002/eureka/,http://eurekathree.com:7003/eureka/

eureka:
  instance:
    hostname: eurekatwo.com
  client:
    register-with-eureka: false
    fetch-registry: false
    eureka-server-u-r-l-context: http://eurekaone.com:7001/eureka/,http://eurekathree.com:7003/eureka/
    
eureka:
  instance:
    hostname: eurekathree.com
  client:
    register-with-eureka: false
    fetch-registry: false
    eureka-server-u-r-l-context: http://eurekaone.com:7001/eureka/,http://eurekatwo.com:7002/eureka/

3)服务提供者修改配置

eureka:
  instance:
    instance-id: moliniao-provider-one
    prefer-ip-address: true
  client:
    service-url:
      defaultZone: http://eurekaone.com:7001/eureka/,http://eurekatwo.com:7002/eureka/,http://eurekathree.com:7003/eureka/


# 错误汇总

错误1:Could not find artifact com.moliniao:XXX:pom:1.0-SNAPSHOT

A项目的sdk模块被B项目依赖，而A的sdk的pom里面有parent节点。本地环境下，多模块项目构建时，
先将parent项目要先install一回，之后子项目才可以运行mvn compile命令,否则就会报如上异常。

错误2:Caused by: java.nio.charset.MalformedInputException: Input length = 1

yml编码问题，改为UTF-8就好

错误3:Cannot execute request on any known server

客户端配置1->eureka.client.eureka-server-u-r-l-context: http://localhost:7001/eureka/        //报错

客户端配置2->eureka.client.service-url.defaultZone: http://localhost:7001/eureka/            //正常注册

错误4:EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN 
THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE 服务端页面显示红色

1)Eureka的自我保护:Netflix在设计Eureka时遵守的就是AP原则
热部署的情况下，改名之后原来的服务时down状态，新的名称是up状态，也即某时刻一个微服务不可用了，Eureka不会立刻清理，依旧会对该微服
务的信息进行保存。

2)什么是自我保护模式？ 
默认情况下，如果EurekaServer在一定时间内没有接收到某个微服务实例的心跳，EurekaServer将会注销该实例(默认90秒)。但是当网络分区故
障发生时，微服务与EurekaServer之间无法正常通信，以上行为可能变得非常危险了——因为微服务本身其实是健康的，此时本不应该注销这个微服务。
Eureka通过“自我保护模式”来解决这个问题——当EurekaServer节点在短时间内丢失过多客户端时(可能发生了网络分区故障)，那么这个节点就会进
入自我保护模式。一旦进入该模式，EurekaServer就会保护服务注册表中的信息，不再删除服务注册表中的数据(也就是不会注销任何微服务)。当
网络故障恢复后，该Eureka Server节点会自动退出自我保护模式。在自我保护模式中，Eureka Server会保护服务注册表中的信息，不再注销任何
服务实例。当它收到的心跳数重新恢复到阈值以上时，该Eureka Server节点就会自动退出自我保护模式。它的设计哲学就是宁可保留错误的服务注
册信息，也不盲目注销任何可能健康的服务实例。一句话讲解:好死不如赖活着综上，自我保护模式是一种应对网络异常的安全保护措施。它的架构
哲学是宁可同时保留所有微服务（健康的微服务和不健康的微服务都会保留），也不盲目注销任何健康的微服务。使用自我保护模式，可以让Eureka
集群更加的健壮、稳定。在Spring Cloud中，在注册中心可以使用eureka.server.enable-self-preservation = false 禁用自我保护模式。

"错误5":UP (1) - YCKJ2786.ad.yc:moliniao-provider-one:8081修改容易识别的名字

增加配置:eureka.instance.instance-id=moliniao-provider-one

"错误6":UP (1) - 悬浮YCKJ2786.ad.yc:moliniao-provider-one:8081链接显示服务主机IP地址

增加配置:eureka.instance.prefer-ip-address=true

"错误7":UP (1) - 点击YCKJ2786.ad.yc:moliniao-provider-one:8081链接info报404，想要正常显示信息

1)服务提供者pom文件新增依赖
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

2)总的父工程修改pom文件添加build信息
    <build>
		<finalName>moliniao-spring-cloud</finalName>
		<resources>
			<resource>
				<directory>src/main/resources</directory>
				<filtering>true</filtering>
			</resource>
		</resources>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-resources-plugin</artifactId>
				<version>3.1.0</version>
				<configuration>
					<delimiters>
						<delimit>$</delimit>
					</delimiters>
				</configuration>
			</plugin>
		</plugins>
	</build>
	
3)服务提供者配置文件添加

info:
  app.name: moliniao-spring-cloud
  company.name: www.moliniao.com
  build.artifactId: ${project.artifactId}
  build.version: ${project.version}

错误8:Feign接口,feign.FeignException$NotFound: status 404 reading StudentOrderService#getStudentOrderInfo(Long)

1)服务消费者和提供者进程运行ok

2)Feign接口通过第三方jar包配置使用

3)三个模块都要引入如下依赖
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>  
        
错误9:com.netflix.client.ClientException: Load balancer does not have available server for client: moliniao-provider-feign

只有一个服务提供者的时候负载均衡会失效
自定义负载均衡配置类不能放在@ComponentScan所扫描的当前包及子包下，否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，也就是
说达不到特殊化定制的目的了。


注:配置文件的名称是configtest.properties，但是如果直接该名称的话是获取不到的，因为在配置文件名需要通过-来进行获取，如果配置文件名称没有-，那么添加了-之后，会自动进行匹配搜索。

Spring Cloud config 的URL与配置文件的映射关系如下:
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties

访问url:
http://configserver.com:3344/application-dev.yml
http://configserver.com:3344/application/dev/master
http://configserver.com:3344/master/application-dev.yml


application.yml 是用户级的资源配置项
bootstrap.yml 是系统级，优先级更高
Spring cloud会创建一个Bootstrap Context，作为spring应用的Application Context的父上下文。初始化的时候，Bootstrap Context负责从外部源加载配置属性并解析配置。
这两个上下文共享一个从外部获取的environment,Bootstrap属性有高优先级，默认情况下，它们不会被本地配置覆盖，Bootstrap Context和Application Context有着不同的约定，
所以新增了一个bootstrap.yml文件，保证Bootstrap Context和Application Context配置的分离。

eureka停更，替代者：zk、consule、nacos

## 1、zk注册中心

是一个基于观察者模式设计的分布式服务管理框架，负责存储和管理大家关心的数据，，然后接手观察者的注册，一旦这些数据的状态发生变化，zk就将负责通知已经在zk上注册的那些观察者作出相应的反应。

zk = 文件系统 + 通知机制

特点：

一个master，多个follower组成的集群

只要有半数以上的节点存活，zk集群就能正常服务

全局数据一致，每个server保存一份相同的数据副本，Client无论连接哪个Server，数据都是一致的

更新请求顺序进行，来自同一个Client的更新请求按其发送顺序依次执行

数据更新原子性，一次数据要么成功，要么失败

实时性，在一定时间范围内，Client能读到最新数据

create -e /sanguo  "shuguo"

create -s /sanguo/shuguo "liubei"

## 2、consul服务注册和发现

what？

是一套开源的分布式服务发现和配置管理系统，用go语言开发。

do what？

服务发现（提供HTTP和DNS两种发现方式），健康监测，KV存储，多数据中心，可视化web界面。

consul --version

consul agent dev

| 组件名    | 语言 | CAP  | 服务健康检查 | 对外暴露服务 | Spring Cloud集成 |
| --------- | ---- | ---- | ------------ | ------------ | ---------------- |
| Eureka    | Java | AP   | 可配支持     | HTTP         | 已集成           |
| Consul    | Go   | CP   | 支持         | HTTP/DNS     | 已集成           |
| Zookeeper | Java | CP   | 支持         | 客户端       | 已集成           |

CP架构：当网络分区出现后，为了保证一致性，就必须拒绝请求，否则无法保证一致性

结论：违背了可用性A的要求，只满足一致性和分区容错性，即CP

## 3、负载均衡

Ribbon本地负载均衡客户端和Nginx服务端负载均衡区别

Nginx即服务器负载均衡，客户端所有请求都交给nginx，然后由nginx实现转发请求，即负载均衡是由服务端实现的。集中式的LB，F5硬件和Nginx软件。

Ribbon本地负载均衡，在调用微服务接口时，会在注册中心上获取注册信息服务列表之后缓存到JVM本地，从而在本地实现RPC远程服务调用技术。进程内的LB，集成于消费方进程

坑：

```java
@RibbonClient(name = "moliniao-provider-ribbon",configuration = CustomRule.class)
服务名称如果是大写，则不起作用。
```

