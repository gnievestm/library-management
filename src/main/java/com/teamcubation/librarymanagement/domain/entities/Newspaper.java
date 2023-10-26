package com.teamcubation.librarymanagement.domain.entities;

import java.util.Date;
import java.util.List;

public class Newspaper {

    private final int id;
    private final String headline;
    private final String date;

    public Newspaper(int id, String headline, String date) {
        this.id = id;
        this.headline = headline;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getHeadline() {
        return headline;
    }

    public String getDate() {
        return date;
    }

}
