package com.teamcubation.librarymanagement.domain.exceptions.book;

public class SearchABookByEmptyTitle extends Exception{
    public SearchABookByEmptyTitle(){
        super("It is impossible to search a book if the title is empty");
    }
}
