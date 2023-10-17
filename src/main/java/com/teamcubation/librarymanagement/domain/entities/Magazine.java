package com.teamcubation.librarymanagement.domain.entities;

import java.util.Date;

public class Magazine {
    private int id;
    private String name;
    private Date date;

    public Magazine(int id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }
}
