package com.teamcubation.librarymanagement.adapter.in.web;

import com.teamcubation.librarymanagement.application.port.in.IRoomPort;
import com.teamcubation.librarymanagement.domain.entities.Room;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomAlreadyExistsException;
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

    @GetMapping(path = "/api/rooms")
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(roomPort.getAllRooms());
    }
}

