package co.wordbe.thejavaspringboot.post;

import co.wordbe.thejavaspringboot.service.ServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class PostAppRunner implements ApplicationRunner {

    @Autowired
    ServiceProperties serviceProperties;

    @Autowired
    Environment environment;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(serviceProperties.getMessage());
        System.out.println("active profiles: " + Arrays.toString(environment.getActiveProfiles()) + " "
                + "default profiles " + Arrays.toString(environment.getDefaultProfiles())
        );
    }
}
