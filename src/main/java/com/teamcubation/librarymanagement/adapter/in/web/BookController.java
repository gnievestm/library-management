package com.teamcubation.librarymanagement.adapter.in.web;

import com.teamcubation.librarymanagement.application.port.in.IBookPort;
import com.teamcubation.librarymanagement.domain.entities.Book;
import com.teamcubation.librarymanagement.domain.exceptions.book.BookSomeEmptyAttributeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    private final IBookPort bookPort;

    public BookController(IBookPort bookPort) {
        this.bookPort = bookPort;
    }

    @GetMapping(path = "/api/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookPort.getAllBooks());
    }

    @PostMapping(path = "/api/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) throws BookSomeEmptyAttributeException {
        bookPort.addBook(book);
        return ResponseEntity.ok(book);
    }

}
