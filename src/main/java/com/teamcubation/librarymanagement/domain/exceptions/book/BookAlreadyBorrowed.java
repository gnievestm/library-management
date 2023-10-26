package com.teamcubation.librarymanagement.domain.exceptions.book;

public class BookAlreadyBorrowed extends Exception{
    public BookAlreadyBorrowed(){
        super("It is impossible to borrow a book that is also borrowed");
    }
}
