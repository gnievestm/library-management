package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Book;
import com.teamcubation.librarymanagement.domain.exceptions.book.BookSomeEmptyAttributeException;
import com.teamcubation.librarymanagement.application.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookServiceTest {
    @Test
    public void addBookCorrectBehavior() throws BookSomeEmptyAttributeException {
        Book bookToSearch=new Book("title1","pepito","2023");
        BookService bookService = BookService.getInstance();
        bookService.addBook(bookToSearch);
        assert(bookService.existBook(bookToSearch));
    }

    @Test
    public void addBookWithSomeEmptyAttribute() throws BookSomeEmptyAttributeException {
        BookService bookService = BookService.getInstance();
        assertThrows(BookSomeEmptyAttributeException.class, () -> {
            bookService.addBook("", "pedro", "2023");
        });
    }




}
