package com.teamcubation.librarymanagement.domain.managers;

import com.teamcubation.librarymanagement.domain.entities.Book;
import com.teamcubation.librarymanagement.domain.exceptions.book.BookSomeEmptyAttributeException;

import java.util.ArrayList;
import java.util.List;

public class BookManager {

    private List<Book> books;

    private List<Book> borrowedBooks;
    private List<Book> availableBooks;

    public BookManager() {
        books = new ArrayList<>();
        borrowedBooks = new ArrayList<>();
        availableBooks = new ArrayList<>();
    }

    public boolean addBook(Book book) throws BookSomeEmptyAttributeException {
        if (books.contains(book)) return false;
        books.add(book);
        availableBooks.add(book);
        return true;
    }

    public List<Book> getAvailableBooks() {
        return this.availableBooks;
    }

    public List<Book> getBorrowedBooks() {
        return this.borrowedBooks;
    }

    public boolean existBook(Book book) {
        return books.contains(book);
    }

    public int countBook() {
        return books.size();
    }

    public boolean addBorrowedBook(Book book) {
        if (borrowedBooks.contains(book)) {
            return false;
        }
        availableBooks.remove(book);
        borrowedBooks.add(book);
        return true;
    }

}
