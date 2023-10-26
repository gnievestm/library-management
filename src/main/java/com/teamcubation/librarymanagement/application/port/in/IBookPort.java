package com.teamcubation.librarymanagement.application.port.in;

import com.teamcubation.librarymanagement.domain.entities.Book;
import com.teamcubation.librarymanagement.domain.entities.User;
import com.teamcubation.librarymanagement.domain.exceptions.book.BookAlreadyBorrowed;
import com.teamcubation.librarymanagement.domain.exceptions.book.BookSomeEmptyAttributeException;
import com.teamcubation.librarymanagement.domain.exceptions.book.NotExistBookException;

import java.util.List;

public interface IBookPort {
    public List<Book> getAllBooks();
    public void addBook(Book book) throws BookSomeEmptyAttributeException;
    public void addBorrowedBook(int idBook) throws NotExistBookException, BookAlreadyBorrowed;
    public List<Book> getBorrowedBooks();
}