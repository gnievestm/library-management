package com.teamcubation.librarymanagement.domain.exceptions.Newspaper;

public class NewspaperDuplicatedException extends Exception {
    public NewspaperDuplicatedException() {
        super("You can´t add a entry that already exist");
    }
}