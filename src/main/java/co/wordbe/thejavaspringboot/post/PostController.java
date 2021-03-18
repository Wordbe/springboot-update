package co.wordbe.thejavaspringboot.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @Value("${exampleData}")
    private DataSize exampleData;

    @Autowired
    ApplicationAvailability availability;

    @GetMapping("/post")
    public String post() {
        return "Application is now " + availability.getLivenessState()
                + " " + availability.getReadinessState();
    }

    @GetMapping("/exampledata")
    public String exampleData() {
        System.out.println(exampleData);
        System.out.println(exampleData.toMegabytes());
        return "hello";
    }
}
