package com.teamcubation.librarymanagement.domain.exceptions.book;

public class BookSomeEmptyAttributeException extends Exception {

    public BookSomeEmptyAttributeException() {
        super("Element with missing attributes cannot be added.");
    }
}
