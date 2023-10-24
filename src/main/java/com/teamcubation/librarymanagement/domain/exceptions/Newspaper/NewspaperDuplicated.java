package com.teamcubation.librarymanagement.domain.exceptions.Newspaper;

public class NewspaperDuplicated extends Exception{
    public NewspaperDuplicated(){
        super("You can´t add a entry that already exist");
    }
}
