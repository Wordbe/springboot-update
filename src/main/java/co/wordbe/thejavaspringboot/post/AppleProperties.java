package co.wordbe.thejavaspringboot.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter @AllArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "apple")
public class AppleProperties {

    private int count;

    private String name;
}
