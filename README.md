# moliniao-spring-cloud
spring-boot版本2.1.10.RELEASE
spring-cloud版本Greenwich.SR4
spring版本5.1.11
更新.ignore文件
git rm -r --cached .
git add .
git commit


eureka服务端配置：
eureka:
  instance:
    hostname: localhost    #eureka服务端的实例名称
  client:
    register-with-eureka: false   #false表示不向注册中心注册自己
    fetch-registry: false         #false表示自己端就是注册中心，我的职责就是维护服务实例，并不需要去检索服务
方式1->OK    service-url: 
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/    #设置与Eureka Server交互的地址查询服务和注册服务都需要依赖这个地址(单机) 
方式2->OK     eureka-server-u-r-l-context: http://${eureka.instance.hostname}:${server.port}/eureka/    #设置与Eureka Server交互的地址查询服务和注册服务都需要依赖这个地址(单机)
    # defaultZone: http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/
    # host-info: eureka7001.com    #eureka服务端的实例名称

eureka集群配置：
1）域名映射：C:\Windows\System32\drivers\etc目录下hosts文件添加
127.0.0.1       eurekaone.com
127.0.0.1       eurekatwo.com
127.0.0.1       eurekathree.com

127.0.0.1       zuul.com
127.0.0.1       config.com
127.0.0.1       clientconfig.com
2）修改yml配置

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

3）服务提供者修改配置
eureka:
  instance:
    instance-id: moliniao-provider-one
    prefer-ip-address: true
  client:
    service-url:
      defaultZone: http://eurekaone.com:7001/eureka/,http://eurekatwo.com:7002/eureka/,http://eurekathree.com:7003/eureka/




错误1：Could not find artifact com.moliniao:XXX:pom:1.0-SNAPSHOT 
原因：A项目的sdk模块被B项目依赖，而A的sdk的pom里面有parent节点。本地环境下，多模块项目构建时，
先将parent项目要先install一回，之后子项目才可以运行mvn compile命令,否则就会报如上异常。

错误2：Caused by: java.nio.charset.MalformedInputException: Input length = 1
yml编码问题，改为UTF-8就好

错误3：Cannot execute request on any known server
客户端配置1->eureka.client.eureka-server-u-r-l-context: http://localhost:7001/eureka/        //报错
客户端配置2->eureka.client.service-url.defaultZone: http://localhost:7001/eureka/            //正常注册

错误4：EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN 
THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE 服务端页面显示红色
1. Eureka的自我保护-->Netflix在设计Eureka时遵守的就是AP原则
热部署的情况下，改名之后原来的服务时down状态，新的名称是up状态，也即某时刻一个微服务不可用了，Eureka不会立刻清理，依旧会对该微服
务的信息进行保存
2. 什么是自我保护模式？ 
默认情况下，如果EurekaServer在一定时间内没有接收到某个微服务实例的心跳，EurekaServer将会注销该实例(默认90秒)。但是当网络分区故
障发生时，微服务与EurekaServer之间无法正常通信，以上行为可能变得非常危险了——因为微服务本身其实是健康的，此时本不应该注销这个微服务。
Eureka通过“自我保护模式”来解决这个问题——当EurekaServer节点在短时间内丢失过多客户端时(可能发生了网络分区故障)，那么这个节点就会进
入自我保护模式。一旦进入该模式，EurekaServer就会保护服务注册表中的信息，不再删除服务注册表中的数据(也就是不会注销任何微服务)。当
网络故障恢复后，该Eureka Server节点会自动退出自我保护模式。在自我保护模式中，Eureka Server会保护服务注册表中的信息，不再注销任何
服务实例。当它收到的心跳数重新恢复到阈值以上时，该Eureka Server节点就会自动退出自我保护模式。它的设计哲学就是宁可保留错误的服务注
册信息，也不盲目注销任何可能健康的服务实例。一句话讲解：好死不如赖活着综上，自我保护模式是一种应对网络异常的安全保护措施。它的架构
哲学是宁可同时保留所有微服务（健康的微服务和不健康的微服务都会保留），也不盲目注销任何健康的微服务。使用自我保护模式，可以让Eureka
集群更加的健壮、稳定。在Spring Cloud中，可以使用eureka.server.enable-self-preservation = false 禁用自我保护模式。
 

"错误5"：UP (1) - YCKJ2786.ad.yc:moliniao-provider-one:8081修改容易识别的名字
增加配置：eureka.instance.instance-id=moliniao-provider-one

"错误6"：UP (1) - 悬浮YCKJ2786.ad.yc:moliniao-provider-one:8081链接显示服务主机IP地址
增加配置：eureka.instance.prefer-ip-address=true

"错误7"：UP (1) - 点击YCKJ2786.ad.yc:moliniao-provider-one:8081链接info报404，想要正常显示信息
1）服务提供者pom文件新增依赖
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
2）总的父工程修改pom文件添加build信息
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
3）服务提供者配置文件添加
info:
  app.name: moliniao-spring-cloud
  company.name: www.moliniao.com
  build.artifactId: ${project.artifactId}
  build.version: ${project.version}
  
错误8:Feign接口,feign.FeignException$NotFound: status 404 reading StudentOrderService#getStudentOrderInfo(Long)
1）服务消费者和提供者进程运行ok
2）Feign接口通过第三方jar包配置使用
3）三个模块都要引入如下依赖
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>  
错误9:com.netflix.client.ClientException: Load balancer does not have available server for client: moliniao-provider-feign
只有一个服务提供者的时候负载均衡会失效

