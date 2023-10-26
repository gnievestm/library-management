package com.teamcubation.librarymanagement.adapter.in.web;

import com.teamcubation.librarymanagement.application.port.in.IBookPort;
import com.teamcubation.librarymanagement.domain.entities.Book;
import com.teamcubation.librarymanagement.domain.exceptions.book.BookAlreadyBorrowed;
import com.teamcubation.librarymanagement.domain.exceptions.book.BookSomeEmptyAttributeException;
import com.teamcubation.librarymanagement.domain.exceptions.book.NotExistBookException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private final IBookPort bookPort;

    public BookController(IBookPort bookPort) {
        this.bookPort = bookPort;
    }

    @GetMapping(path = "/api/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookPort.getAllBooks());
    }

    @PostMapping(path = "/api/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) throws BookSomeEmptyAttributeException {
        bookPort.addBook(book);
        return ResponseEntity.ok(book);
    }

    @PostMapping(path = "/api/books/{id}/borrowBook")
    public ResponseEntity<Integer> addBorrowedBook(@PathVariable("id") int id) throws BookAlreadyBorrowed, NotExistBookException {
        bookPort.addBorrowedBook(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping(path = "/api/books?borrowedBooks={borrowedValue}")
    public ResponseEntity<List<Book>> getBorrowedBooks(@PathVariable("borrowedValue") String borrowedValue) {
        if (borrowedValue.equals("true")) return ResponseEntity.ok(bookPort.getBorrowedBooks());
        return null;
    }
}
