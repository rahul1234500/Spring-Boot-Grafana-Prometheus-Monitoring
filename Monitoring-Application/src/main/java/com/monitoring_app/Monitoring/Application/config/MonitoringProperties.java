package com.monitoring_app.Monitoring.Application.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app.monitoring")
public class MonitoringProperties {

    private String greetingMessage;
    private Metrics metrics = new Metrics();

    @Getter
    @Setter
    public static class Metrics {
        private String requestCounterName;
        private String requestTimerName;
        private String statusTagKey;
    }
}
