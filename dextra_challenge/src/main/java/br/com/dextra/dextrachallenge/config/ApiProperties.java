package br.com.dextra.dextrachallenge.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "api")
@Configuration("apiKeyProperties")
@Data
public class ApiProperties {

    private String key;
}
