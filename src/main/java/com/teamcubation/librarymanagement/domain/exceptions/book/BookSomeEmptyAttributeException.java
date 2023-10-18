package com.teamcubation.librarymanagement.domain.exceptions.book;

public class BookSomeEmptyAttributeException extends Exception{

    public BookSomeEmptyAttributeException(){
        super("It´s impossible to add an element that has some empty attribute");
    }
}
