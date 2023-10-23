package com.teamcubation.librarymanagement.domain.exceptions.computer;

public class ComputerInvalidIDException extends Exception {

    public ComputerInvalidIDException() {
        super("ID is not Valid");
    }
}
