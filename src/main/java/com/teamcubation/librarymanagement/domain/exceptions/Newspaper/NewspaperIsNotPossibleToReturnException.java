package com.teamcubation.librarymanagement.domain.exceptions.Newspaper;

public class NewspaperIsNotPossibleToReturnException extends Exception {
    public NewspaperIsNotPossibleToReturnException() {
        super("There are not need to return a Newspaper");
    }
}
