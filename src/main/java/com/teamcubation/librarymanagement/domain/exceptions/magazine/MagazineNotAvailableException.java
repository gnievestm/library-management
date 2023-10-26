package com.teamcubation.librarymanagement.domain.exceptions.magazine;

public class MagazineNotAvailableException extends Exception {
    public MagazineNotAvailableException() {
        super("Your magazine is not available");
    }
}
