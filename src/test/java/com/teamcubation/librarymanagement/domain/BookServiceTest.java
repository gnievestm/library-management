package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Book;
import com.teamcubation.librarymanagement.domain.exceptions.book.BookSomeEmptyAttributeException;
import com.teamcubation.librarymanagement.service.BookService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookServiceTest {

    @Test
    public void addBookCorrectBehavior() throws BookSomeEmptyAttributeException {
        Book bookToSearch = new Book("la divina comedia", "Dante", "1950");
        BookService bookService = BookService.getInstance();
        bookService.addBook(bookToSearch);
        assert (bookService.existBook(bookToSearch));
    }

    @Test
    public void addBookWithSomeEmptyAttribute(){
        BookService bookService = BookService.getInstance();
        assertThrows(BookSomeEmptyAttributeException.class, () -> {
            bookService.addBook("El hombre en busca de sentido", "", "2000");
        });
    }

    @Test
    public void getAvailableBooks() {
        BookService bookService = BookService.getInstance();
        bookService.getAvailableBooks();

        List<Book> result = bookService.getAvailableBooks();

        assertEquals("[Book{ title=la divina comedia,author='Dante',yearOfPublishing='1950'}]",result.toString());

    }
}
