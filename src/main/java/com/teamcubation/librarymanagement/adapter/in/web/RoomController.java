package com.teamcubation.librarymanagement.adapter.in.web;

import com.teamcubation.librarymanagement.application.port.in.IRoomPort;
import com.teamcubation.librarymanagement.domain.entities.Room;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomAlreadyExistsException;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomAlreadyReservedException;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    private final IRoomPort roomPort;

    public RoomController(IRoomPort roomPort) {
        this.roomPort = roomPort;
    }

    @PostMapping(path = "/api/rooms")
    public ResponseEntity<Room> createRoom(@RequestBody Room room) throws RoomAlreadyExistsException {
        roomPort.createRoom(room);
        return ResponseEntity.ok(room);
    }

    @PostMapping(path = "/api/rooms/reserve")
    public ResponseEntity<Room> reserveRoom(@RequestBody Room room) throws RoomNotFoundException, RoomAlreadyReservedException {

        roomPort.reserveRoom(room);
        return ResponseEntity.ok(room);
    }

    @GetMapping(path = "/api/rooms")
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(roomPort.getAllRooms());
    }

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
}

