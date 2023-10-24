package com.teamcubation.librarymanagement.domain.entities;

import java.util.Objects;

public class BorrowMagazine {
    private Magazine magazine;

    private boolean isBorrow;

    public Magazine getMagazine() {
        return magazine;
    }

    public boolean getIsBorrow() {
        return isBorrow;
    }

    public void setBorrow(boolean borrow) {
        isBorrow = borrow;
    }

    public BorrowMagazine(Magazine magazine, boolean isBorrow) {
        this.magazine = magazine;
        this.isBorrow = isBorrow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorrowMagazine that = (BorrowMagazine) o;
        return Objects.equals(magazine, that.magazine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(magazine, isBorrow);
    }
}
