package co.wordbe.thejavaspringboot.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/post")
    public String post() {
        postService.printPost();
        return "hello";
    }
}
