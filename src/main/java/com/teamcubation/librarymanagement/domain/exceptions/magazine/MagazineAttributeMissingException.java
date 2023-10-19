package com.teamcubation.librarymanagement.domain.exceptions.magazine;

public class MagazineAttributeMissingException extends Exception {
    public MagazineAttributeMissingException() {
        super("Your magazine attributes are void");
    }
}
