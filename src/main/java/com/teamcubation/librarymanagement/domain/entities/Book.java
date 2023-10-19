package com.teamcubation.librarymanagement.domain.entities;

import java.util.Objects;

import java.time.*;

public class Book {

    private static int predefinedBookId = 0;
    private int bookId;
    private String author;
    private String title;
    private Year yearOfPublishing;

    public Book(String title, String author, String yearOfPublishing) {
        this.bookId = Book.predefinedBookId++;
        this.author = author;
        this.title = title;
        this.yearOfPublishing = Year.parse(yearOfPublishing);
    }

    public Book(int id, String title, String author, String yearOfPublishing) {
        this.bookId = id;
        this.author = author;
        this.title = title;
        this.yearOfPublishing = Year.parse(yearOfPublishing);
    }

    private int getBookId() {
        return bookId;
    }

    public Year getYearOfPublishing() {
        return yearOfPublishing;
    }

    private int getPredefinedBookId() {
        return predefinedBookId;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return bookId == ((Book) o).bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getAuthor(), getTitle(), getYearOfPublishing());
    }
}
