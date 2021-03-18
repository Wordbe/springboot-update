package co.wordbe.thejavaspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("devController")
@RestController
public class DevController {

    @Autowired
    MyService myService;

    @GetMapping("/dev")
    public String hello() {
        return myService.getMessage();
    }
}
