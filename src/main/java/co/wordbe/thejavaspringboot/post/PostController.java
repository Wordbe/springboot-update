package co.wordbe.thejavaspringboot.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
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
