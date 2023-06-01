package com.example.onlinestoreofcomputer.service;

import com.example.onlinestoreofcomputer.entity.HardDisk;
import com.example.onlinestoreofcomputer.repository.HardDiskRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class HardDiskService {

    private final HardDiskRepository hardDiskRepository;

    public HardDiskService(HardDiskRepository hardDiskRepository) {
        this.hardDiskRepository = hardDiskRepository;
    }

    public Collection<HardDisk> getAllHardDisk() {
        return hardDiskRepository.findAll();
    }

    public HardDisk getHardDisk(Long id) {
        return hardDiskRepository.findById(id).orElse(null);
    }

    public HardDisk createHardDisk(HardDisk hardDisk) {
        return hardDiskRepository.save(hardDisk);
    }

    public HardDisk editHardDisk(HardDisk hardDisk) {
        HardDisk hardDiskEdit = hardDiskRepository.findById(hardDisk.getId()).orElse(null);
        if (hardDiskEdit == null) {
            return null;
        } else {
            return hardDiskRepository.save(hardDisk);
        }
    }

    public boolean deleteHardDisk(Long id) {
        HardDisk hardDisk = hardDiskRepository.findById(id).orElse(null);
        if (hardDisk == null) {
            return false;
        } else {
            hardDiskRepository.deleteById(id);
            return true;
        }
    }


}
