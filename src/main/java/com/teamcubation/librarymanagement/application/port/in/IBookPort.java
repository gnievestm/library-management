package com.teamcubation.librarymanagement.application.port.in;

import com.teamcubation.librarymanagement.domain.entities.Book;
import com.teamcubation.librarymanagement.domain.entities.User;
import com.teamcubation.librarymanagement.domain.exceptions.book.*;

import java.util.List;

public interface IBookPort {
    public List<Book> getAllBooks();
    public void addBook(Book book) throws BookSomeEmptyAttributeException;
    public void addBorrowedBook(int idBook) throws NotExistBookException, BookAlreadyBorrowed;
    public List<Book> getBorrowedBooks();
    public List<Book> getAvailableBooks();
    public void returnBorrowedBook(int idBook) throws NotExistBookException, ReturnABookthatIsNotBorrowed;
    public List<Book> searchBookByTitle(String title) throws SearchABookByEmptyTitle;

}