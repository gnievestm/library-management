package com.teamcubation.librarymanagement.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerMissingFieldsException;

public class Computer {

    private int id;
    private String brand;
    private String model;

    public Computer(int id, String brand, String model) throws ComputerMissingFieldsException {
        if (brand == null || model == null) {
            throw new ComputerMissingFieldsException();
        }

        this.id = id;
        this.brand = brand;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return id == (computer.id);
    }

    @Override
    public String toString() {
        return "Computer{" + "id = " + id + '\'' + "brand='" + brand + '\'' + ", model='" + model + '\'' + '}';
    }
}
