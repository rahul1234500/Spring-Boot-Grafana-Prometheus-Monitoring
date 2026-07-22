package com.monitoring_app.Monitoring.Application.service;

import com.monitoring_app.Monitoring.Application.config.MonitoringProperties;
import org.springframework.stereotype.Service;

@Service
public class MonitoringService {
    private final MonitoringProperties monitoringProperties;
    private final MetricsHelper metricsHelper;

    public MonitoringService(MonitoringProperties monitoringProperties, MetricsHelper metricsHelper) {
        this.monitoringProperties = monitoringProperties;
        this.metricsHelper = metricsHelper;
    }
    public String processMonitorRequest() {
        try {
            return metricsHelper.recordExecutionTime("success", () -> {
                // Simulate business logic processing delay
                Thread.sleep((long) (Math.random() * 80 + 20));

                metricsHelper.incrementCounter("success");
                return monitoringProperties.getGreetingMessage();
            });
        } catch (Exception e) {
            metricsHelper.incrementCounter("failure");
            throw new RuntimeException("Error processing monitoring request", e);
        }
    }
}
