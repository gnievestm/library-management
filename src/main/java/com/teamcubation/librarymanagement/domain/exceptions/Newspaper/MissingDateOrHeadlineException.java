package com.teamcubation.librarymanagement.domain.exceptions.Newspaper;

public class MissingDateOrHeadlineException extends Exception{
    public MissingDateOrHeadlineException(){
        super("Date and headline cannot be null nor empty.");
    }

}
