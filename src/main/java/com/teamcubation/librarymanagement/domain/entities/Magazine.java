package com.teamcubation.librarymanagement.domain.entities;

import java.util.Date;
import java.util.Objects;

public class Magazine {
    private final int id;
    static int magazineIds = 0;
    private final String name;
    private final Date date;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public Magazine(String name, Date date) {
        this.name = name;
        this.date = date;
        this.id = ++Magazine.magazineIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magazine magazine = (Magazine) o;
        return id == magazine.id && Objects.equals(name, magazine.name) && Objects.equals(date, magazine.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date);
    }
}
