package com.monitoring_app.Monitoring.Application.service;

import com.monitoring_app.Monitoring.Application.config.MonitoringProperties;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Component;


import java.util.concurrent.Callable;

@Component
public class MetricsHelper {
    private final MeterRegistry meterRegistry;
    private final MonitoringProperties monitoringProperties;

    public MetricsHelper(MeterRegistry meterRegistry, MonitoringProperties monitoringProperties) {
        this.meterRegistry = meterRegistry;
        this.monitoringProperties = monitoringProperties;
    }

    public MetricsHelper incrementCounter(String statusValue){
        Counter.builder(monitoringProperties.getMetrics().getRequestCounterName())
                .description("Total number of monitor endpoint calls")
                .tag(monitoringProperties.getMetrics().getStatusTagKey(), statusValue)
                .register(meterRegistry)
                .increment();
        return this;
    }
    public <T> T recordExecutionTime(String tagValue, Callable<T> task) throws Exception {
        return Timer.builder(monitoringProperties.getMetrics().getRequestTimerName())
                .description("Latency distribution of monitor operations")
                .tag(monitoringProperties.getMetrics().getStatusTagKey(), tagValue)
                .publishPercentiles(0.5, 0.9, 0.95, 0.99)
                .register(meterRegistry)
                .recordCallable(task);
    }
}
