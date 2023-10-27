package com.teamcubation.librarymanagement.adapter.in.web;

import com.teamcubation.librarymanagement.application.port.in.IBookPort;
import com.teamcubation.librarymanagement.domain.entities.Book;
import com.teamcubation.librarymanagement.domain.exceptions.book.*;
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

    @PostMapping(path = "api/books/{id}/borrow")
    public ResponseEntity<Integer> addBorrowedBook(@PathVariable("id") int idBook) throws BookAlreadyBorrowed, NotExistBookException {
        bookPort.addBorrowedBook(idBook);
        return ResponseEntity.ok(idBook);
    }

    @GetMapping(path = "/api/books?borrowed={borrow}")
    public ResponseEntity<List<Book>> getBorrowedBooks(@PathVariable("borrow") boolean borrow) {
        return ResponseEntity.ok(bookPort.getBorrowedBooks());
    }

    @GetMapping(path = "/api/books?available={available}")
    public ResponseEntity<List<Book>> getAvailableBooks(@PathVariable("available") boolean available) {
        return ResponseEntity.ok(bookPort.getAvailableBooks());
    }

    @PostMapping(path = "/api/books/{id}/return")
    public ResponseEntity<Integer> returnBorrowedBook(@PathVariable("id") int id) throws ReturnABookthatIsNotBorrowed, NotExistBookException {
        bookPort.returnBorrowedBook(id);
        return ResponseEntity.ok(id);
    }

    @PostMapping(path = "/api/searchBooks")
    public ResponseEntity<List<Book>> searchBookByTitle(@RequestParam String search) throws ReturnABookthatIsNotBorrowed, NotExistBookException, SearchABookByEmptyTitle {
        return ResponseEntity.ok(bookPort.searchBookByTitle(search));
    }
}
