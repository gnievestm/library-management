package com.teamcubation.librarymanagement.application.service;

import com.teamcubation.librarymanagement.domain.entities.Book;
import com.teamcubation.librarymanagement.domain.exceptions.book.BookSomeEmptyAttributeException;
import com.teamcubation.librarymanagement.domain.managers.BookManager;

public class BookService {

    static BookService instance;

    private BookManager BookManager;

    public static BookService getInstance() {
        if (instance == null)
            instance = new BookService();
        return instance;
    }

    private BookService() {
        this.BookManager = new BookManager();
    }

    public void addBook(String title, String author, String publishYear) throws BookSomeEmptyAttributeException {
        if (title.isEmpty() || author.isEmpty() || publishYear.isEmpty())
            throw new BookSomeEmptyAttributeException();
        Book book = new Book(title, author, publishYear);
        this.BookManager.addBook(book);
    }

    public void addBook(Book book) throws BookSomeEmptyAttributeException {
        if (book.getTitle().isEmpty() || book.getAuthor().isEmpty() || book.getYearOfPublishing() == null)
            throw new BookSomeEmptyAttributeException();
        this.BookManager.addBook(book);
    }

    public int countBook(){
        return BookManager.countBook();
    }

    public boolean existBook(Book book) {
        return BookManager.existBook(book);
    }
}