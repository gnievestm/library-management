package com.teamcubation.librarymanagement.domain.entities;

import java.util.Objects;

import java.time.*;

public class Book {
    static int predefinedBookId = 0;
    private final int bookId;
    private final String author;
    private final String title;
    private final Year yearOfPublishing;

    public Book(String title, String author, String yearOfPublishing) {
        this.bookId = Book.predefinedBookId++;
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

    public static int getPredefinedBookId() {
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

    public String toString() {
        return "Book{" + " title=" + this.title + ",author='" + this.author + '\'' + ",yearOfPublishing='" + this.yearOfPublishing + '\'' + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getAuthor(), getTitle(), getYearOfPublishing());
    }
}
