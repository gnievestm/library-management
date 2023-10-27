package com.teamcubation.librarymanagement.application.port.in;

import com.teamcubation.librarymanagement.domain.entities.Computer;

import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerAlreadyExists;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerMissingFieldsException;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerNotAvailableException;

import java.util.List;

public interface IComputerPort {

    List<String> getAllComputers();

    List<String> getAllAvailableComputers();

    void addComputer(Computer computer) throws ComputerMissingFieldsException, ComputerAlreadyExists;

    Computer reserveComputer(int computerId)  throws ComputerNotAvailableException;

}
