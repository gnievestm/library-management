package com.teamcubation.librarymanagement.domain.entities;

import java.util.Objects;

public class Book {

    static int id=0;
    private String autor;

    private String title;
    private String publishYear;

    public Book(String title,String autor,String publishYear){
        this.id=Book.id++;
        this.autor=autor;
        this.title=title;
        this.publishYear=publishYear;
    }

    public static int getId() {
        return id;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitle() {
        return title;
    }

    public String getPublishYear() {
        return publishYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(autor, book.autor) && Objects.equals(title, book.title) && Objects.equals(publishYear, book.publishYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autor, title, publishYear);
    }
}
