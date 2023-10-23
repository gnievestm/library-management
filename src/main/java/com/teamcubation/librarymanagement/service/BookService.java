package com.teamcubation.librarymanagement.service;

import com.teamcubation.librarymanagement.domain.entities.Book;
import com.teamcubation.librarymanagement.domain.exceptions.book.BookAlreadyBorrowed;
import com.teamcubation.librarymanagement.domain.exceptions.book.BookSomeEmptyAttributeException;
import com.teamcubation.librarymanagement.domain.exceptions.book.NotExistBookException;
import com.teamcubation.librarymanagement.domain.managers.BookManager;

import java.util.List;

public class BookService {

    static BookService instance;
    private BookManager BookManager;

    public static BookService getInstance() {
        if (instance == null) instance = new BookService();
        return instance;
    }

    private BookService() {
        this.BookManager = new BookManager();
    }

    public void addBook(String title, String author, String publishYear) throws BookSomeEmptyAttributeException {
        if (title.isEmpty() || author.isEmpty() || publishYear.isEmpty()) throw new BookSomeEmptyAttributeException();
        Book book = new Book(title, author, publishYear);
        this.BookManager.addBook(book);
    }

    public void addBook(Book book) throws BookSomeEmptyAttributeException {
        if (book.getTitle().isEmpty() || book.getAuthor().isEmpty() || book.getYearOfPublishing() == null)
            throw new BookSomeEmptyAttributeException();
        this.BookManager.addBook(book);
    }

    public List<Book> getAvailableBooks() {
        return BookManager.getAvailableBooks();
    }

    public List<Book> getBorrowedBooks() {
        return BookManager.getBorrowedBooks();
    }

    public int countBook() {
        return BookManager.countBook();
    }

    public boolean existBook(Book book) {
        return BookManager.existBook(book);
    }

    public void addBorrowedBook(Book book) throws NotExistBookException, BookAlreadyBorrowed {
        if(!BookManager.existBook(book)){
            throw new NotExistBookException();
        }
        if(BookManager.getBorrowedBooks().contains(book)){
            throw new BookAlreadyBorrowed();
        }
        BookManager.addBorrowedBook(book);
    }
}
