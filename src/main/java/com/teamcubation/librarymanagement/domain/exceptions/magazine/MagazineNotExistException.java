package com.teamcubation.librarymanagement.domain.exceptions.magazine;

public class MagazineNotExistException extends Exception{
    public MagazineNotExistException() {
        super("The magazine does not exist");
    }
}
