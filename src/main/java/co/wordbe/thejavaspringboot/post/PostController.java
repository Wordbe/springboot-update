package co.wordbe.thejavaspringboot.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @Value("${exampleData}")
    private DataSize exampleData;

    @GetMapping("/post")
    public String post() {
        System.out.println(exampleData);
        System.out.println(exampleData.toMegabytes());
        return "hello";
    }
}
