package co.wordbe.thejavaspringboot.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@AllArgsConstructor @Getter
@ConstructorBinding
@ConfigurationProperties(prefix = "service")
public class ServiceProperties {
    private String message;
}
