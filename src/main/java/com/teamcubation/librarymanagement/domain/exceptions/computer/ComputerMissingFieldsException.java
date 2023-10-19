package com.teamcubation.librarymanagement.domain.exceptions.computer;

public class ComputerMissingFieldsException extends Exception {

    public ComputerMissingFieldsException (){
        super("You must complete all the fields");
    }
}
