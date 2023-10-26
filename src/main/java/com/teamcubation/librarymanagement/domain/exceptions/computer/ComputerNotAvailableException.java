package com.teamcubation.librarymanagement.domain.exceptions.computer;

public class ComputerNotAvailableException extends Exception {

    public ComputerNotAvailableException() {
        super("The computer is not available to be reserved");
    }
}
