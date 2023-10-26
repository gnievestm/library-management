package com.teamcubation.librarymanagement.application.service;

import com.teamcubation.librarymanagement.application.port.in.IBookPort;
import com.teamcubation.librarymanagement.domain.entities.Book;
import com.teamcubation.librarymanagement.domain.exceptions.book.*;
import com.teamcubation.librarymanagement.domain.managers.BookManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookPort {

    static BookService instance;
    private final BookManager BookManager;

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


    @Override
    public List<Book> getAllBooks() {
        return BookManager.getAllBooks();
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
        return BookManager.existBook(book.getBookId());
    }

    public void addBorrowedBook(int idBook) throws NotExistBookException, BookAlreadyBorrowed {
        if (!BookManager.existBook(idBook)) {
            throw new NotExistBookException();
        }
        if (BookManager.isBookBorrowed(idBook)) {
            throw new BookAlreadyBorrowed();
        }
        BookManager.addBorrowedBook(idBook);
    }

    public List<Book> searchBookByTitle(String title) throws SearchABookByEmptyTitle {
        if (title.isEmpty())
            throw new SearchABookByEmptyTitle();
        return BookManager.searchBookByTitle(title);
    }

    public void returnBorrowedBook(Book book) throws NotExistBookException, ReturnABookthatIsNotBorrowed {
        if (!BookManager.existBook(book.getBookId())) {
            throw new NotExistBookException();
        }
        BookManager.returnBorrowedBook(book);
    }
}
