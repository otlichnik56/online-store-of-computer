package com.example.onlinestoreofcomputer.controller;

import com.example.onlinestoreofcomputer.entity.HardDisk;
import com.example.onlinestoreofcomputer.service.HardDiskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/hard_disks")
public class HardDiskController {

    private final HardDiskService hardDiskService;

    public HardDiskController(HardDiskService hardDiskService) {
        this.hardDiskService = hardDiskService;
    }

    @GetMapping
    public ResponseEntity<Collection<HardDisk>> getAllHardDisk() {
        Collection<HardDisk> result = hardDiskService.getAllHardDisk();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHardDisk(@PathVariable Long id) {
        HardDisk hardDisk = hardDiskService.getHardDisk(id);
        if (hardDisk == null) {
            return ResponseEntity.status(404).body("Not found");
        } else {
            return ResponseEntity.status(200).body(hardDisk);
        }
    }

    @PostMapping
    public HardDisk createHardDisk(@RequestBody HardDisk hardDisk) {
        return hardDiskService.createHardDisk(hardDisk);
    }

    @PatchMapping
    public ResponseEntity<?> editHardDisk(@RequestBody HardDisk hardDisk) {
        if (hardDiskService.editHardDisk(hardDisk) == null) {
            return ResponseEntity.status(404).body("Not found");
        } else {
            return ResponseEntity.status(200).body(hardDisk);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteHardDisk(@PathVariable Long id) {
        if (hardDiskService.deleteHardDisk(id)) {
            return ResponseEntity.status(200).body("Successfully deleted");
        } else {
            return ResponseEntity.status(404).body("Not found");
        }
    }

}
