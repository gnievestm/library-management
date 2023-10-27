package com.teamcubation.librarymanagement.adapter.in.web;

import com.teamcubation.librarymanagement.application.port.in.IComputerPort;
import com.teamcubation.librarymanagement.domain.entities.Computer;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerAlreadyExistsException;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerMissingFieldsException;
import com.teamcubation.librarymanagement.domain.exceptions.computer.ComputerNotAvailableException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComputerController {

    private final IComputerPort computerPort;

    public ComputerController(IComputerPort computerPort) {
        this.computerPort = computerPort;
    }

    @PostMapping(path = "/api/computers")
    public ResponseEntity<Computer> addComputer(@RequestBody Computer computer) throws ComputerMissingFieldsException, ComputerAlreadyExistsException {
        computerPort.addComputer(computer);
        return ResponseEntity.ok(computer);
    }

    @GetMapping(path = "/api/computers")
    public ResponseEntity<List<String>> getAllComputers() {
        return ResponseEntity.ok(computerPort.getAllComputers());
    }

    @GetMapping(path = "/api/computers?available={available}")
    public ResponseEntity<List<String>> getAllAvailableComputers() {
        return ResponseEntity.ok(computerPort.getAllAvailableComputers());
    }

    @PostMapping(path = "/api/computers/{id}/reserve")
    public ResponseEntity<Computer> reserveComputer(@PathVariable("id") int computerId) throws ComputerNotAvailableException {
        Computer reservedComputer = computerPort.reserveComputer(computerId);
        return ResponseEntity.ok(reservedComputer);
    }

    @PatchMapping(path = "/api/computers/{id}/reserve")
    public ResponseEntity<Computer> cancelReservation(@PathVariable("id") int computerId) {
        Computer cancelledReservation = computerPort.cancelReservation(computerId);
        return ResponseEntity.ok(cancelledReservation);
    }
}
