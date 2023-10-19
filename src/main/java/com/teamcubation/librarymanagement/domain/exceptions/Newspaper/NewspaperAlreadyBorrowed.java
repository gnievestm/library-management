package com.teamcubation.librarymanagement.domain.exceptions.Newspaper;

public class NewspaperAlreadyBorrowed extends Exception{

    public NewspaperAlreadyBorrowed(){
        super("This newspaper is not available");
    }
}
