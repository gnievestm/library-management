package com.teamcubation.librarymanagement.domain.exceptions.Newspaper;

public class NewspaperIsNotPossibleToReturn extends Exception{
    public NewspaperIsNotPossibleToReturn(){
        super("There are not need to return a Newspaper");
    }
}
