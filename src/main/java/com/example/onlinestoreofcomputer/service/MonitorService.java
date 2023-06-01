package com.example.onlinestoreofcomputer.service;

import com.example.onlinestoreofcomputer.entity.Monitor;
import com.example.onlinestoreofcomputer.repository.MonitorRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MonitorService {

    private final MonitorRepository monitorRepository;

    public MonitorService(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    public Collection<Monitor> getAllMonitor() {
        return monitorRepository.findAll();
    }

    public Monitor getMonitor(Long id) {
        return monitorRepository.findById(id).orElse(null);
    }

    public Monitor createMonitor(Monitor monitor) {
        return monitorRepository.save(monitor);
    }

    public Monitor editMonitor(Monitor monitor) {
        Monitor monitorEdit = monitorRepository.findById(monitor.getId()).orElse(null);
        if (monitorEdit == null) {
            return null;
        } else {
            return monitorRepository.save(monitor);
        }
    }

    public boolean deleteMonitor(Long id) {
        Monitor monitor = monitorRepository.findById(id).orElse(null);
        if (monitor == null) {
            return false;
        } else {
            monitorRepository.deleteById(id);
            return true;
        }
    }


}
