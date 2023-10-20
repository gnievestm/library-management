package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Computer;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerInvalidID;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerMissingFieldsException;
import com.teamcubation.librarymanagement.service.ComputerService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ComputerServiceTest {

    @Test
    void addComputer() throws ComputerMissingFieldsException, ComputerInvalidID {

        ComputerService computerService = ComputerService.getInstance();
        computerService.addComputer(1, "brand", "model");
        Computer computer = new Computer(1, "brand", "model");

        boolean found = computerService.existComputer(computer.getComputerID());

        assertTrue(found);
    }

    @Test
    void addComputerNull() {

        assertThrows(ComputerMissingFieldsException.class,
                () -> {
                    ComputerService computerService = ComputerService.getInstance();
                    computerService.addComputer(1, null, "model");
                });
    }

    @Test
    void negativeID() {

        assertThrows(ComputerInvalidID.class,
                () -> {
                    ComputerService computerService = ComputerService.getInstance();
                    computerService.addComputer(-1, "brand", "model");
                });
    }

    @Test
    void idZero() {

        assertThrows(ComputerInvalidID.class,
                () -> {
                    ComputerService computerService = ComputerService.getInstance();
                    computerService.addComputer(0, "brand", "model");
        });
    }
}
