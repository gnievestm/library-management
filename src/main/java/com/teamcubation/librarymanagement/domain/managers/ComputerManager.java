package com.teamcubation.librarymanagement.domain.managers;

import com.teamcubation.librarymanagement.domain.entities.Computer;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerAlreadyExists;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerMissingFieldsException;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerNotAvailableException;

import java.util.ArrayList;
import java.util.List;

public class ComputerManager {
    private int computerIds = 1;
    private final List<Computer> computerList;
    private final List<Computer> reservedComputers;

    public ComputerManager() {
        computerList = new ArrayList<>();
        reservedComputers = new ArrayList<>();
    }

    public boolean addComputer(String brand, String model) throws ComputerMissingFieldsException, ComputerAlreadyExists {
        Computer computer = new Computer(computerIds++, brand, model);
        if (computerList.contains(computer)) throw new ComputerAlreadyExists();
        computerList.add(computer);
        return true;
    }

    public List<String> getComputers() {
        List<String> computers = new ArrayList<>();
        for (Computer c : computerList) {
            computers.add(c.toString());
        }
        for (Computer c : reservedComputers) {
            computers.add(c.toString());
        }
        return computers;
    }

    public boolean existComputer(int id) {
        for (Computer c : computerList)
            if (c.getId() == id) return true;
        for (Computer c : reservedComputers)
            if (c.getId() == id) return true;
        return false;
    }

    public void reserveComputer(int computerId) throws ComputerNotAvailableException {
        Computer toReserve = null;
        for (Computer c : this.computerList) {
            if (c.getId() == computerId) toReserve = c;
        }
        if (toReserve == null) throw new ComputerNotAvailableException();

        reservedComputers.add(toReserve);
        computerList.remove(toReserve);
    }

    public boolean cancelReservation(int computerId) {
        Computer toCancel = null;
        for (Computer c : reservedComputers) {
            if (c.getId() == computerId) toCancel = c;
        }
        if (toCancel == null) return false;

        reservedComputers.remove(toCancel);
        computerList.add(toCancel);
        return true;
    }

    public List<String> getAvailableComputers() {
        List<String> computers = new ArrayList<>();
        for (Computer c : computerList) {
            computers.add(c.toString());
        }
        return computers;
    }
}
