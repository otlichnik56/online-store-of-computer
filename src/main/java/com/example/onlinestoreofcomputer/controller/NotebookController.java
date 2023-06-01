package com.example.onlinestoreofcomputer.controller;

import com.example.onlinestoreofcomputer.entity.Notebook;
import com.example.onlinestoreofcomputer.service.NotebookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/notebooks")
public class NotebookController {

    private final NotebookService notebookService;

    public NotebookController(NotebookService notebookService) {
        this.notebookService = notebookService;
    }

    @GetMapping
    public ResponseEntity<Collection<Notebook>> getAllNotebook() {
        Collection<Notebook> result = notebookService.getAllNotebook();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNotebook(@PathVariable Long id) {
        Notebook notebook = notebookService.getNotebook(id);
        if (notebook == null) {
            return ResponseEntity.status(404).body("Not found");
        } else {
            return ResponseEntity.status(200).body(notebook);
        }
    }

    @PostMapping
    public Notebook createNotebook(@RequestBody Notebook notebook) {
        return notebookService.createNotebook(notebook);
    }

    @PatchMapping
    public ResponseEntity<?> editNotebook(@RequestBody Notebook notebook) {
        if (notebookService.editNotebook(notebook) == null) {
            return ResponseEntity.status(404).body("Not found");
        } else {
            return ResponseEntity.status(200).body(notebook);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteNotebook(@PathVariable Long id) {
        if (notebookService.deleteNotebook(id)) {
            return ResponseEntity.status(200).body("Successfully deleted");
        } else {
            return ResponseEntity.status(404).body("Not found");
        }
    }

}
