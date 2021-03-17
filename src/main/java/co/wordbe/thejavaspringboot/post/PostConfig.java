package co.wordbe.thejavaspringboot.post;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class PostConfig {

    @Bean
    public Object postObject() {
        return new Object();
    }
}
