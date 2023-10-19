package com.teamcubation.librarymanagement.domain.exceptions.magazine;

public class MagazineAttributeNameMissingException extends Exception{
    public MagazineAttributeNameMissingException(){
        super("Your Name for magazine is void");
    }
}
