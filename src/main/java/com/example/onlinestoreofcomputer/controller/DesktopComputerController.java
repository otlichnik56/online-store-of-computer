package com.example.onlinestoreofcomputer.controller;

import com.example.onlinestoreofcomputer.entity.DesktopComputer;
import com.example.onlinestoreofcomputer.service.DesktopComputerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/desktop_computers")
public class DesktopComputerController {

    private final DesktopComputerService desktopComputerService;

    public DesktopComputerController(DesktopComputerService desktopComputerService) {
        this.desktopComputerService = desktopComputerService;
    }

    @GetMapping
    public ResponseEntity<Collection<DesktopComputer>> getAllDesktopComputer() {
        Collection<DesktopComputer> result = desktopComputerService.getAllDesktopComputer();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDesktopComputer(@PathVariable Long id) {
        DesktopComputer desktopComputer = desktopComputerService.getDesktopComputer(id);
        if (desktopComputer == null) {
            return ResponseEntity.status(404).body("Not found");
        } else {
            return ResponseEntity.status(200).body(desktopComputer);
        }
    }

    @PostMapping
    public DesktopComputer createDesktopComputer(@RequestBody DesktopComputer desktopComputer) {
        return desktopComputerService.createDesktopComputer(desktopComputer);
    }

    @PatchMapping
    public ResponseEntity<?> editDesktopComputer(@RequestBody DesktopComputer desktopComputer) {
        if (desktopComputerService.editDesktopComputer(desktopComputer) == null) {
            return ResponseEntity.status(404).body("Not found");
        } else {
            return ResponseEntity.status(200).body(desktopComputer);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDesktopComputer(@PathVariable Long id) {
        if (desktopComputerService.deleteDesktopComputer(id)) {
            return ResponseEntity.status(200).body("Successfully deleted");
        } else {
            return ResponseEntity.status(404).body("Not found");
        }
    }

}
