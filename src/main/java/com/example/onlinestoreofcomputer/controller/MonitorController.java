package com.example.onlinestoreofcomputer.controller;

import com.example.onlinestoreofcomputer.entity.Monitor;
import com.example.onlinestoreofcomputer.service.MonitorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/monitors")
public class MonitorController {

    private final MonitorService monitorService;

    public MonitorController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @GetMapping
    public ResponseEntity<Collection<Monitor>> getAllMonitor() {
        Collection<Monitor> result = monitorService.getAllMonitor();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMonitor(@PathVariable Long id) {
        Monitor monitor = monitorService.getMonitor(id);
        if (monitor == null) {
            return ResponseEntity.status(404).body("Not found");
        } else {
            return ResponseEntity.status(200).body(monitor);
        }
    }

    @PostMapping
    public Monitor createMonitor(@RequestBody Monitor monitor) {
        return monitorService.createMonitor(monitor);
    }

    @PatchMapping
    public ResponseEntity<?> editMonitor(@RequestBody Monitor monitor) {
        if (monitorService.editMonitor(monitor) == null) {
            return ResponseEntity.status(404).body("Not found");
        } else {
            return ResponseEntity.status(200).body(monitor);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMonitor(@PathVariable Long id) {
        if (monitorService.deleteMonitor(id)) {
            return ResponseEntity.status(200).body("Successfully deleted");
        } else {
            return ResponseEntity.status(404).body("Not found");
        }
    }

}
