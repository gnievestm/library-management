package com.teamcubation.librarymanagement.adapter.in.web.exceptionhandling;

import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineAttributeMissingException;
import com.teamcubation.librarymanagement.domain.exceptions.magazine.MagazineNotAvailableException;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomAlreadyExistsException;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomAlreadyReservedException;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ControllerExceptionHandling {

    @ExceptionHandler(RoomAlreadyReservedException.class)
    public ResponseEntity<String> handleRoomAlreadyReservedException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La sala ya ha sido reservada");
    }

    @ExceptionHandler(RoomAlreadyExistsException.class)
    public ResponseEntity<String> handleRoomAlreadyExistsException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La sala ya existe");
    }

    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity<String> handleRoomNotFoundException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se encontro la sala");
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