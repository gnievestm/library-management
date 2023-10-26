package com.teamcubation.librarymanagement.service;

import com.teamcubation.librarymanagement.domain.entities.Book;
import com.teamcubation.librarymanagement.domain.exceptions.book.*;
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

    public boolean existBook(int id) {
        return BookManager.existBook(id);
    }

    public void addBorrowedBook(int id) throws NotExistBookException, BookAlreadyBorrowed {
        if(!BookManager.existBook(id)){
            throw new NotExistBookException();
        }
        if(BookManager.getBorrowedBooks().contains(id)){
            throw new BookAlreadyBorrowed();
        }
        BookManager.addBorrowedBook(id);
    }

    public List<Book> searchBookByTitle(String title) throws SearchABookByEmptyTitle {
        if(title.isEmpty())
            throw new SearchABookByEmptyTitle();
        return BookManager.searchBookByTitle(title);
    }
    public void returnBorrowedBook(int id) throws NotExistBookException, ReturnABookthatIsNotBorrowed {
        if(!BookManager.existBook(id)){
            throw new NotExistBookException();
        }
        BookManager.returnBorrowedBook(id);
    }
}
