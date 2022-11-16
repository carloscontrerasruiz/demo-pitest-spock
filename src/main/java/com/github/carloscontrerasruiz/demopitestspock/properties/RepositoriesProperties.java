package com.github.carloscontrerasruiz.demopitestspock.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "repositories")
@Data
public class RepositoriesProperties {
    private Map<String, ShowsProperties> shows;
}
