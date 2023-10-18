package com.teamcubation.librarymanagement.domain.managers;

import com.teamcubation.librarymanagement.domain.entities.Book;
import com.teamcubation.librarymanagement.domain.exceptions.book.BookSomeEmptyAttributeException;

import java.util.ArrayList;
import java.util.List;

public class BookManager {

    private List<Book> books;

    public BookManager(){
        books=new ArrayList<>();
    }

    public void addBook(Book book) throws BookSomeEmptyAttributeException {
        if(book.getTitle().isEmpty() || book.getAutor().isEmpty() || book.getPublishYear().isEmpty())
            throw new BookSomeEmptyAttributeException();
        books.add(book);
    }

    public boolean existBook(Book book){
        return books.contains(book);
    }
}
