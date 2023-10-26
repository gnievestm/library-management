package com.teamcubation.librarymanagement.application.service;

import com.teamcubation.librarymanagement.application.port.in.IBookPort;
import com.teamcubation.librarymanagement.domain.entities.Book;
import com.teamcubation.librarymanagement.domain.entities.User;
import com.teamcubation.librarymanagement.domain.exceptions.book.BookSomeEmptyAttributeException;
import com.teamcubation.librarymanagement.domain.managers.BookManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookPort {

    private final BookManager BookManager;

    public BookService() {
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

    public int countBook() {
        return BookManager.countBook();
    }

    public boolean existBook(Book book) {
        return BookManager.existBook(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return BookManager.getAllBooks();
    }


}
