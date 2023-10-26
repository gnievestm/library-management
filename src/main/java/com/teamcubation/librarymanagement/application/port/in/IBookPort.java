package com.teamcubation.librarymanagement.application.port.in;

import com.teamcubation.librarymanagement.domain.entities.Book;
import com.teamcubation.librarymanagement.domain.entities.User;
import com.teamcubation.librarymanagement.domain.exceptions.book.BookSomeEmptyAttributeException;

import java.util.List;

public interface IBookPort {
    public List<Book> getAllBooks();
    public void addBook(Book book) throws BookSomeEmptyAttributeException;
}