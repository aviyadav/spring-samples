package org.sample.s3.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties("app")
@Configuration
public class ApplicationProperties {
    
    private AwsService awsService;

    @Data
    public static class AwsService {
        private String bucketName;
    }
}
