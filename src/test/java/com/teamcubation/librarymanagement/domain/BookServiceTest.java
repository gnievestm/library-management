package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Book;
import com.teamcubation.librarymanagement.domain.exceptions.book.BookSomeEmptyAttributeException;
import com.teamcubation.librarymanagement.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookServiceTest {
    @Test
    public void addBookCorrectBehavior() throws BookSomeEmptyAttributeException {
        BookService bookService=BookService.getInstance();
        bookService.addBook("title1","pepito","2023");
        Book book=new Book("title1","pepito","2023");
        assert(bookService.existBook(book));
    }

    @Test
    public void addBookWithSomeEmptyAttribute()throws BookSomeEmptyAttributeException {
        BookService bookService=BookService.getInstance();
        BookSomeEmptyAttributeException exception =assertThrows(BookSomeEmptyAttributeException.class,()->{
            bookService.addBook("","pedro","2023");
        });
        assertEquals(exception.getMessage(),"It´s impossible to add an element that has some empty attribute");
    }

}
