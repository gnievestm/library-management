package com.teamcubation.librarymanagement.domain.exceptions.Newspaper;

public class NewspaperNotFoundException extends Exception {

    public NewspaperNotFoundException() {
        super("There is not a newspaper with this data");
    }
}
