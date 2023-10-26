package com.teamcubation.librarymanagement.domain.exceptions.book;

public class NotExistBookException extends Exception{

    public NotExistBookException(){
        super("It is impossible to borrow a book that does not exist");
    }
}

