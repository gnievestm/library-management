package com.teamcubation.librarymanagement.domain.exceptions.magazine;

public class MagazineYourDoesNotExistException extends Exception {
    public MagazineYourDoesNotExistException() {super("Your magazine is not available");
    }
}
