package co.wordbe.thejavaspringboot.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

    @Component
    public class PostAppRunner implements ApplicationRunner {

        @Autowired
        AppleProperties appleProperties;

        @Override
        public void run(ApplicationArguments args) throws Exception {
            System.out.println(appleProperties.getCount());
            System.out.println(appleProperties.getName());
        }
    }
