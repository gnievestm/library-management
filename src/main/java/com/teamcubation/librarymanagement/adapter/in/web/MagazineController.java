package com.teamcubation.librarymanagement.adapter.in.web;

import com.teamcubation.librarymanagement.application.port.in.IMagazinePort;
import com.teamcubation.librarymanagement.domain.entities.BorrowMagazine;
import com.teamcubation.librarymanagement.domain.entities.Magazine;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributeMissingException;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineNotAvailableException;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineNotExistException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MagazineController {
    private final IMagazinePort magazinePort;

    public MagazineController(IMagazinePort magazinePort) {
        this.magazinePort = magazinePort;
    }


    @GetMapping(path = "/api/magazines")
    public ResponseEntity<List<BorrowMagazine>> getAllMagazineAndStatus() {
        return ResponseEntity.ok(magazinePort.getAllMagazine());
    }


    @GetMapping(path = "/api/magazines/?search={name}")
    public ResponseEntity<Magazine> searchMagazine(@PathVariable("name") String magazineName) throws MagazineNotExistException {
        return ResponseEntity.ok(magazinePort.searchMagazine(magazineName));
    }

    @PostMapping(path = "/api/magazines/create")
    public ResponseEntity<Magazine> addMagazine(@RequestParam("dateOfJoining")@DateTimeFormat(pattern="dd-MM-yyyy")@RequestBody Magazine magazine ) throws MagazineAttributeMissingException {
        magazinePort.addMagazine(magazine);
        return ResponseEntity.ok(magazine);

    }

    @PostMapping(path = "/api/magazines/borrow")
    public ResponseEntity<Magazine> borrowMagazine(@RequestBody Magazine magazine) throws MagazineNotAvailableException {

        magazinePort.borrowMagazine(magazine);
        return ResponseEntity.ok(magazine);
    }

    @PostMapping(path = "/api/magazines/return")
    public ResponseEntity<Magazine> returnMagazine(@RequestBody Magazine magazine) {
        magazinePort.returnMagazine(magazine);
        return ResponseEntity.ok(magazine);
    }

    @ExceptionHandler({MagazineAttributeMissingException.class})
    public ResponseEntity<String> handleExceptionMagazineAttributeMissingException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Your magazine attributes are void");
    }
    @ExceptionHandler({MagazineNotAvailableException.class})
    public ResponseEntity<String> handleExceptionMagazineNotAvailableException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Your magazine is not available");
    }

}

