package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Book;
import com.teamcubation.librarymanagement.domain.exceptions.book.*;
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
    public void addBookWithSomeEmptyAttribute() throws BookSomeEmptyAttributeException {
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
        for (Book book : result) {
            System.out.println(book.toString());
        }
    }

    @Test
    public void addBorrowedBookCorrectBehavior() throws BookSomeEmptyAttributeException, NotExistBookException, BookAlreadyBorrowed {
        Book bookToBorrow = new Book("Capelucita roja", "no sé", "1944");
        BookService bookService = BookService.getInstance();
        bookService.addBook(bookToBorrow);
        bookService.addBorrowedBook(bookToBorrow);
        List<Book> result = bookService.getBorrowedBooks();

        assertEquals(1, result.size());
    }


    @Test
    public void addAlreadyBorrowedBook() throws BookAlreadyBorrowed, NotExistBookException, BookSomeEmptyAttributeException {
        Book bookToBorrow2 = new Book("Hamlet", "authorcito", "2010");
        BookService bookService = BookService.getInstance();
        bookService.addBook(bookToBorrow2);
        bookService.addBorrowedBook(bookToBorrow2);
        assertThrows(BookAlreadyBorrowed.class, () -> {
            bookService.addBorrowedBook(bookToBorrow2);
        });
    }

    @Test
    public void addBookThatNotExist() throws BookAlreadyBorrowed, NotExistBookException, BookSomeEmptyAttributeException {
        Book bookExample4 = new Book("los tres chanchitos", "author", "2010");
        BookService bookService = BookService.getInstance();

        assertThrows(NotExistBookException.class, () -> {
            bookService.addBorrowedBook(bookExample4);
        });
    }

    @Test
    public void returnBorrowedBookCorrectBehavior() throws BookSomeEmptyAttributeException, BookAlreadyBorrowed, NotExistBookException, ReturnABookthatIsNotBorrowed {
        Book bookToBorrow3 = new Book("La biblia", "sin autor", "1000");
        BookService bookService = BookService.getInstance();
        bookService.addBook(bookToBorrow3);
        bookService.addBorrowedBook(bookToBorrow3);
        bookService.returnBorrowedBook(bookToBorrow3);
        List<Book> result = bookService.getBorrowedBooks();
        assertEquals(0, result.size());
    }

    @Test
    public void returnABookThatisNotBorrowedBook() throws BookSomeEmptyAttributeException, BookAlreadyBorrowed, NotExistBookException, ReturnABookthatIsNotBorrowed {
        Book bookToBorrow4 = new Book("Blancanieves", "sin autor", "1000");
        BookService bookService = BookService.getInstance();
        bookService.addBook(bookToBorrow4);
        assertThrows(ReturnABookthatIsNotBorrowed.class, () -> {
            bookService.returnBorrowedBook(bookToBorrow4);
        });
    }

    @Test
    public void returnABookThatNotExist() throws BookSomeEmptyAttributeException, BookAlreadyBorrowed, NotExistBookException, ReturnABookthatIsNotBorrowed {
        Book bookToBorrow5 = new Book("La eduación de la voluntad", "Author", "2020");
        BookService bookService = BookService.getInstance();
        assertThrows(NotExistBookException.class, () -> {
            bookService.returnBorrowedBook(bookToBorrow5);
        });
    }

    @Test
    public void searchABookByTitleCorrectBehavior() throws SearchABookByEmptyTitle {
        BookService bookService=BookService.getInstance();
        List <Book> result=bookService.searchBookByTitle("La");
        assertEquals("[Book{ title=La biblia,author='sin autor',yearOfPublishing='1000'}, Book{ title=la divina comedia,author='Dante',yearOfPublishing='1950'}]",result.toString());
    }

    @Test
    public void searchABookByTitleEmptyTitle() throws SearchABookByEmptyTitle {
        BookService bookService=BookService.getInstance();
        assertThrows(SearchABookByEmptyTitle.class,()->{
            bookService.searchBookByTitle("");
        });
    }
}
