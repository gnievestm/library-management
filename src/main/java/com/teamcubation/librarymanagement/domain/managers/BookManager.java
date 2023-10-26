package com.teamcubation.librarymanagement.domain.managers;

import com.teamcubation.librarymanagement.domain.entities.Book;
import com.teamcubation.librarymanagement.domain.exceptions.book.BookSomeEmptyAttributeException;
import com.teamcubation.librarymanagement.domain.exceptions.book.ReturnABookthatIsNotBorrowed;

import java.util.ArrayList;
import java.util.List;

public class BookManager {

    private List<Book> books;
    private List<Book> borrowedBooks;
    private List<Book> availableBooks;

    public BookManager() {
        books = new ArrayList<>();
        borrowedBooks = new ArrayList<>();
        availableBooks = new ArrayList<>();
    }

    public boolean addBook(Book book) throws BookSomeEmptyAttributeException {
        if (books.contains(book)) return false;
        books.add(book);
        availableBooks.add(book);
        return true;
    }

    public List<Book> searchBookByTitle(String title){
        List<Book> foundedBooks=new ArrayList<>();
        for(Book book:books)
            if(book.getTitle().toLowerCase().contains(title.toLowerCase()))
                foundedBooks.add(book);
        return foundedBooks;
    }

    public List<Book> getAvailableBooks() {
        return this.availableBooks;
    }

    public List<Book> getBorrowedBooks() {
        return this.borrowedBooks;
    }

    public List<Book> getAllBooks(){
        return this.books;
    }
    public boolean existBook(int idBook) {
        for(Book book: books)
            if(book.getBookId() ==  idBook)
                return true;
        return false;
    }

    public int countBook() {
        return books.size();
    }

    public boolean addBorrowedBook(int idBook) {
        for(Book book:books){
            if (borrowedBooks.contains(book)) {
                return false;
            }
            if(book.getBookId()==idBook){
                availableBooks.remove(book);
                borrowedBooks.add(book);
            }
        }
        return true;
    }
    public boolean returnBorrowedBook(Book book) throws ReturnABookthatIsNotBorrowed {
        if(!borrowedBooks.contains(book)){
            throw new ReturnABookthatIsNotBorrowed();
        }
        borrowedBooks.remove(book);
        availableBooks.add(book);
        return true;
    }

}
