package xyz.cloorc.example.springboot.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Soiff on 2016/5/15.
 * Rebuild project will generate proper 'META-INF/spring-configuration-metadata.json',
 * which will do key completion when configuration typed in yaml or properties files.
 */
@ConfigurationProperties(prefix = SimpleProperties.PREFIX, locations = {"classpath:simple.yml"})
public class SimpleProperties {
    final static String PREFIX = "example.simple";

    @Getter @Setter
    private String location;
}
