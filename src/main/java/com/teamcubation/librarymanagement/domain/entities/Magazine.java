package com.teamcubation.librarymanagement.domain.entities;

import java.util.Date;
import java.util.Objects;

public class Magazine {
    private int id;
    static int magazineIds = 0;
    private String name;
    private String date;

    public int getId() {
        return id;
    }

    public static int getMagazineIds() {
        return magazineIds;
    }

    public String getName() {
        return name;
    }


    public String getDate() {
        return date;
    }

    public Magazine(String name, String date) {
        this.name = name;
        this.date = date;
        this.id = ++Magazine.magazineIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magazine magazine = (Magazine) o;
        return Objects.equals(name, magazine.name) && Objects.equals(date, magazine.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date);
    }
}
