package me.projects.inventoryservice.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "cors")
@Getter @Setter
public class CorsProperties {
    private String allowedOrigin;
    private String allowedHeaders;
    private String allowedMethods;
}
