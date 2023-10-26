package com.teamcubation.librarymanagement.application.service;

import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerMissingFieldsException;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerNotAvailableException;
import com.teamcubation.librarymanagement.domain.managers.ComputerManager;
import com.teamcubation.librarymanagement.domain.entities.Computer;

import java.util.List;

public class ComputerService {
    private final ComputerManager computerManager;

    public ComputerService() {
        this.computerManager = new ComputerManager();
    }

    public void addComputer(String brand, String model) throws ComputerMissingFieldsException {

        this.computerManager.addComputer(brand, model);
    }

    public boolean existComputer(int id) {
        return computerManager.existComputer(id);
    }

    public void reserveComputer(int computerId) throws ComputerNotAvailableException {
        computerManager.reserveComputer(computerId);
    }

    public List<String> getAllComputers() {
        return computerManager.getComputers();
    }

    public List<String> getAllAvailableComputers() {
        return computerManager.getAvailableComputers();
    }
}
