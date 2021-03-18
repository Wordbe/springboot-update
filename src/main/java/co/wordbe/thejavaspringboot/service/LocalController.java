package co.wordbe.thejavaspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalController {

    @Autowired
    ApplicationAvailability availability;

    @Autowired
    LocalHostService localHostService;

    @GetMapping("/local")
    public String local() {
        return "Appliation is now " + availability.getLivenessState()
                + " " + availability.getReadinessState()
                + " " + localHostService.getLocalHostInfo();
    }
}