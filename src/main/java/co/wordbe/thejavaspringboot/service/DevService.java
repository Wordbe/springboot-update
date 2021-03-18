package co.wordbe.thejavaspringboot.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("devService")
@Service
public class DevService implements MyService {

    @Override
    public String getMessage() {
        return "dev";
    }
}
