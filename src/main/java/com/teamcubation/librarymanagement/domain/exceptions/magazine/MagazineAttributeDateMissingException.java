package com.teamcubation.librarymanagement.domain.exceptions.magazine;

public class MagazineAttributeDateMissingException extends Exception {
    public MagazineAttributeDateMissingException() {
        super("Your date for magazine is void");
    }
}
