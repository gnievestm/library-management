package com.teamcubation.librarymanagement.domain.entities;

import java.util.Objects;

import java.time.*;

public class Book {

    static int predefinedBookId = 0;
    private String author;
    private String title;
    private Year yearOfPublishing;

    public Book(String title, String autor, String yearOfPublishing) {
        this.predefinedBookId = Book.predefinedBookId++;
        this.author = autor;
        this.title = title;
        this.yearOfPublishing = Year.parse(yearOfPublishing);
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
        return Objects.equals(getPredefinedBookId(), book.getPredefinedBookId()) && Objects.equals(getAuthor(), book.getAuthor()) && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(yearOfPublishing, book.yearOfPublishing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthor(), getTitle(), yearOfPublishing);
    }
}
