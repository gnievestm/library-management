package com.teamcubation.librarymanagement.service;

import com.teamcubation.librarymanagement.domain.entities.Book;
import com.teamcubation.librarymanagement.domain.exceptions.book.BookSomeEmptyAttributeException;
import com.teamcubation.librarymanagement.domain.managers.BookManager;

public class BookService {

    static BookService instance;

    private BookManager BookManager;

    public static BookService getInstance(){
        if(instance ==null)
            instance=new BookService();
        return instance;
    }

    private BookService(){
        this.BookManager=new BookManager();
    }

    public void addBook(String title, String autor,String publishYear) throws BookSomeEmptyAttributeException {
        Book book=new Book(title,autor,publishYear);
        this.BookManager.addBook(book);
    }

    public boolean existBook(Book book){
        return BookManager.existBook(book);
    }
}
