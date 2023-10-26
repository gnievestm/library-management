package com.teamcubation.librarymanagement.domain.exceptions.computer;

public class ComputerAlreadyExistsException extends Exception {
    public ComputerAlreadyExistsException() {
        super("The computer already exists");
    }
}
