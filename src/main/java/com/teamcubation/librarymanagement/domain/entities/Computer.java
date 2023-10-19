package com.teamcubation.librarymanagement.domain.entities;

import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerMissingFieldsException;

public class Computer {

    private static int comoputerID = 0;
    private String brand;
    private String model;


    public Computer(String brand, String model) throws ComputerMissingFieldsException {
        if (brand==null || model==null){
            throw new ComputerMissingFieldsException();
        }
        this.brand = brand;
        this.model = model;
    }

    public int getComputerID() {
        return comoputerID;
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
        return brand.equals(computer.brand) && model.equals(computer.model);
    }
}
