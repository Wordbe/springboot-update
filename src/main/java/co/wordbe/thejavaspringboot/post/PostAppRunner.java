package co.wordbe.thejavaspringboot.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

    @Component
    public class PostAppRunner implements ApplicationRunner {

        @Autowired
        PostConfig postConfig;

        @Override
        public void run(ApplicationArguments args) throws Exception {
            System.out.println(postConfig.postObject());
            System.out.println(postConfig.postObject());
            System.out.println(postConfig.postObject());
            System.out.println(postConfig.postObject());
            System.out.println(postConfig.postObject());
        }
    }
