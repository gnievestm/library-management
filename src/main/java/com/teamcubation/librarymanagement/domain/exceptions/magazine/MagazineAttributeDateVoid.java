package com.teamcubation.librarymanagement.domain.exceptions.magazine;

public class MagazineAttributeDateVoid extends Exception {
    public MagazineAttributeDateVoid() {
        super("Your date for magazine is void");
    }
}
