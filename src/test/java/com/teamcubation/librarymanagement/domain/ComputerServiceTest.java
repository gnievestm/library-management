package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Computer;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerMissingFieldsException;
import com.teamcubation.librarymanagement.service.ComputerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ComputerServiceTest {

    @Test
    void addComputer() throws ComputerMissingFieldsException {

        ComputerService computerService = ComputerService.getInstance();
        computerService.addComputer("brand","model");
        Computer computer = new Computer("brand","model");

        boolean found = computerService.existComputer(computer);

        assertTrue(found);
    }
    @Test
    void addComputerNull() {

            assertThrows(ComputerMissingFieldsException.class,
                    ()->{
                        ComputerService computerService = ComputerService.getInstance();
                        computerService.addComputer(null,"model");
                    });

    }
}
