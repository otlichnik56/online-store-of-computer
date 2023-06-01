package com.example.onlinestoreofcomputer.service;

import com.example.onlinestoreofcomputer.entity.DesktopComputer;
import com.example.onlinestoreofcomputer.repository.DesktopComputerRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DesktopComputerService {

    private final DesktopComputerRepository desktopComputerRepository;

    public DesktopComputerService(DesktopComputerRepository desktopComputerRepository) {
        this.desktopComputerRepository = desktopComputerRepository;
    }

    public Collection<DesktopComputer> getAllDesktopComputer() {
        return desktopComputerRepository.findAll();
    }

    public DesktopComputer getDesktopComputer(Long id) {
        return desktopComputerRepository.findById(id).orElse(null);
    }

    public DesktopComputer createDesktopComputer(DesktopComputer desktopComputer) {
        return desktopComputerRepository.save(desktopComputer);
    }

    public DesktopComputer editDesktopComputer(DesktopComputer desktopComputer) {
        DesktopComputer desktopComputerEdit = desktopComputerRepository.findById(desktopComputer.getId()).orElse(null);
        if (desktopComputerEdit == null) {
            return null;
        } else {
            return desktopComputerRepository.save(desktopComputer);
        }
    }

    public boolean deleteDesktopComputer(Long id) {
        DesktopComputer desktopComputer = desktopComputerRepository.findById(id).orElse(null);
        if (desktopComputer == null) {
            return false;
        } else {
            desktopComputerRepository.deleteById(id);
            return true;
        }
    }


}
