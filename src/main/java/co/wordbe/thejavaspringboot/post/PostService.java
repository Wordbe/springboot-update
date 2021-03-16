package co.wordbe.thejavaspringboot.post;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Async
    public void printPost() {
        System.out.println("(post) thread: " + Thread.currentThread().getName());
    }

//    @Scheduled(fixedDelay = 1000 * 2)
//    public void printHi() {
//        System.out.println("(hi) thread: " + Thread.currentThread().getName());
//    }
}
