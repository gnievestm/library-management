package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Computer;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerInvalidIDException;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerMissingFieldsException;
import com.teamcubation.librarymanagement.service.ComputerService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ComputerServiceTest {

    @Test
    void adduserTest() throws ComputerInvalidIDException, ComputerMissingFieldsException {
        ComputerService computerService = ComputerService.getInstance();
        computerService.addComputer(1, "brand", "model");
        Computer computer = new Computer(1, "brand", "model");
        boolean found = computerService.existComputer(computer);

        assertTrue(found);
    }

    @Test
    void addComputerNullTest() {

        assertThrows(ComputerMissingFieldsException.class,
                () -> {
                    ComputerService computerService = ComputerService.getInstance();
                    computerService.addComputer(1, null, "model");
                });
    }

    @Test
    void negativeIDTest() {

        assertThrows(ComputerInvalidIDException.class,
                () -> {
                    ComputerService computerService = ComputerService.getInstance();
                    computerService.addComputer(-1, "brand", "model");
                });
    }

    @Test
    void idZeroTest() {

        assertThrows(ComputerInvalidIDException.class,
                () -> {
                    ComputerService computerService = ComputerService.getInstance();
                    computerService.addComputer(0, "brand", "model");
                });
    }
}
