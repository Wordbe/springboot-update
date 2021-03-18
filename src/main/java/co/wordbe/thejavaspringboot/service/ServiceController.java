package co.wordbe.thejavaspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @Autowired
    ApplicationAvailability availability;

    @Autowired
    LocalHostService localHostService;

    @GetMapping("/service")
    public String local() {
        return "Appliation is now " + availability.getLivenessState()
                + " " + availability.getReadinessState()
                + " " + localHostService.getLocalHostInfo();
    }

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @GetMapping("/turnoff")
    public String turnoff() {
        AvailabilityChangeEvent.publish(eventPublisher, this, LivenessState.BROKEN);
        return "Broken";
    }

    @GetMapping("/block")
    public String block() {
        AvailabilityChangeEvent.publish(eventPublisher, this, ReadinessState.REFUSING_TRAFFIC);
        return "Blocked requests";
    }

    @Async
    @EventListener
    public void onStateChanged(AvailabilityChangeEvent<ReadinessState> readiness) throws InterruptedException {
        System.out.println("State is changed to " + readiness.getState());
        if (readiness.getState() == ReadinessState.REFUSING_TRAFFIC) {
            Thread.sleep(5000L);
            AvailabilityChangeEvent.publish(eventPublisher, this, ReadinessState.ACCEPTING_TRAFFIC);
        }
    }
}
