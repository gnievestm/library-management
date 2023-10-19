package com.teamcubation.librarymanagement.domain.entities;

public class BorrowMagazine {
    private Magazine magazine;
    private String status;

    public Magazine getMagazine() {
        return magazine;
    }

    public String getStatus() {
        return status;
    }

    public BorrowMagazine(Magazine magazine, String status) {
        this.magazine = magazine;
        this.status = status;
    }

}
