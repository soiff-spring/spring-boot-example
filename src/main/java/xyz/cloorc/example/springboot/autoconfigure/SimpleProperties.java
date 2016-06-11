package xyz.cloorc.example.springboot.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Soiff on 2016/5/15.
 * Rebuild project will generate proper 'META-INF/spring-configuration-metadata.json',
 * which will do key completion when configuration typed in yaml or properties files.
 */
@Configuration
@ConditionalOnProperty(prefix = "example.simple", name = "enabled")
public class SimpleProperties {

    @ToString
    @ConfigurationProperties(prefix = Simple.PREFIX, locations = {"classpath:simple.yml"})
    public static class Simple {
        final static String PREFIX = "example.simple";

        @Getter @Setter
        private String location;
    }
}
