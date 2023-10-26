package com.teamcubation.librarymanagement.domain.exceptions.Newspaper;

public class NewspaperNotFound extends Exception {

    public NewspaperNotFound() {
        super("There is not a newspaper with this data");
    }
}
