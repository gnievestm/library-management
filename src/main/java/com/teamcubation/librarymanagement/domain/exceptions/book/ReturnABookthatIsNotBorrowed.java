package com.teamcubation.librarymanagement.domain.exceptions.book;

public class ReturnABookthatIsNotBorrowed extends Exception{
    public ReturnABookthatIsNotBorrowed(){
        super("It is impossible to return a book that did not borrowed");
    }
}