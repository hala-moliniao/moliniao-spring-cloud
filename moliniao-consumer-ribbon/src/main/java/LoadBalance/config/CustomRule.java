package LoadBalance.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: created by limingzhou
 * @date: 2019/12/29
 * @description: com.moliniao.config
 */
@Configuration
public class CustomRule {

    @Bean
    public IRule getIRule() {
        return new RetryRule();
    }
}
