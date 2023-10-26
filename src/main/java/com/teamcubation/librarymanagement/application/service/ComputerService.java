package com.teamcubation.librarymanagement.application.service;

import com.teamcubation.librarymanagement.application.port.in.IComputerPort;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerAlreadyExists;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerInvalidID;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerMissingFieldsException;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerNotAvailableException;
import com.teamcubation.librarymanagement.domain.managers.ComputerManager;
import com.teamcubation.librarymanagement.domain.entities.Computer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerService implements IComputerPort {
    private final ComputerManager computerManager;

    public ComputerService() {
        this.computerManager = new ComputerManager();
    }

    public void addComputer(String brand, String model) throws ComputerMissingFieldsException, ComputerInvalidID, ComputerAlreadyExists {

        this.computerManager.addComputer(brand, model);
    }

    public boolean existComputer(int id) {
        return computerManager.existComputer(id);
    }

    public void reserveComputer(int computerId) throws ComputerNotAvailableException {
        computerManager.reserveComputer(computerId);
    }

    @Override
    public List<String> getAllComputers() {
        return computerManager.getComputers();
    }

    @Override
    public List<String> getAllAvailableComputers() {
        return computerManager.getAvailableComputers();
    }

    @Override
    public void addComputer(Computer computer) throws ComputerAlreadyExists, ComputerInvalidID, ComputerMissingFieldsException {
        this.computerManager.addComputer(computer.getBrand(), computer.getModel());
    }

}
