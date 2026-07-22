package com.monitoring_app.Monitoring.Application.controller;

import com.monitoring_app.Monitoring.Application.service.MonitoringService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestController {
    private final MonitoringService monitoringService;

    public TestController(MonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }

    @GetMapping("/monitor")
    public ResponseEntity<String> monitor(){
        String response = monitoringService.processMonitorRequest();
        return ResponseEntity.ok(response);
    }
}
