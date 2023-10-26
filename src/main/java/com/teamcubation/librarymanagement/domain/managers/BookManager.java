package com.teamcubation.librarymanagement.domain.managers;

import com.teamcubation.librarymanagement.domain.entities.Book;
import com.teamcubation.librarymanagement.domain.entities.User;
import com.teamcubation.librarymanagement.domain.exceptions.book.BookSomeEmptyAttributeException;

import java.util.ArrayList;
import java.util.List;

public class BookManager {

    private final List<Book> books;

    public BookManager() {
        books = new ArrayList<>();
    }

    public boolean addBook(Book book) throws BookSomeEmptyAttributeException {
        if (books.contains(book))
            return false;
        books.add(book);
        return true;
    }

    public List<Book> getAllBooks(){
        return this.books;
    }
    public boolean existBook(Book book) {
        return books.contains(book);
    }

    public int countBook() {
        return books.size();
    }

}
