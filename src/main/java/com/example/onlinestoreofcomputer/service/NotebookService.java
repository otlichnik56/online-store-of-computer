package com.example.onlinestoreofcomputer.service;

import com.example.onlinestoreofcomputer.entity.DesktopComputer;
import com.example.onlinestoreofcomputer.entity.Notebook;
import com.example.onlinestoreofcomputer.repository.DesktopComputerRepository;
import com.example.onlinestoreofcomputer.repository.NotebookRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class NotebookService {

    private final NotebookRepository notebookRepository;

    public NotebookService(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }

    public Collection<Notebook> getAllNotebook() {
        return notebookRepository.findAll();
    }

    public Notebook getNotebook(Long id) {
        return notebookRepository.findById(id).orElse(null);
    }

    public Notebook createNotebook(Notebook notebook) {
        return notebookRepository.save(notebook);
    }

    public Notebook editNotebook(Notebook notebook) {
        Notebook notebookEdit = notebookRepository.findById(notebook.getId()).orElse(null);
        if (notebookEdit == null) {
            return null;
        } else {
            return notebookRepository.save(notebook);
        }
    }

    public boolean deleteNotebook(Long id) {
        Notebook notebook = notebookRepository.findById(id).orElse(null);
        if (notebook == null) {
            return false;
        } else {
            notebookRepository.deleteById(id);
            return true;
        }
    }


}
