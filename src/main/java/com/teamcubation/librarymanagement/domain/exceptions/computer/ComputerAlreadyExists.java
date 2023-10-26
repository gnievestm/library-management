package com.teamcubation.librarymanagement.domain.exceptions.computer;

public class ComputerAlreadyExists extends Exception{
    public  ComputerAlreadyExists() {
        super("The computer already exists");
    }
}
