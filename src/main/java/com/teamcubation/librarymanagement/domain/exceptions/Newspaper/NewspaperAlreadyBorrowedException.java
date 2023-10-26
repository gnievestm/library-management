package com.teamcubation.librarymanagement.domain.exceptions.Newspaper;

public class NewspaperAlreadyBorrowedException extends Exception{

    public NewspaperAlreadyBorrowedException(){
        super("This newspaper is not available");
    }
}
