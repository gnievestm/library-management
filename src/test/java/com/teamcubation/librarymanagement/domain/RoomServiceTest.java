package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Room;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomAlreadyExistsException;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomIncompleteFieldsException;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomInvalidIdException;
import com.teamcubation.librarymanagement.service.RoomService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class RoomServiceTest {

    @Test
    void addRoom() throws RoomIncompleteFieldsException, RoomInvalidIdException, RoomAlreadyExistsException {

        RoomService roomService = RoomService.getInstance();
        Room room = new Room(1, "name", "address");
        roomService.addRoom(1, "name", "address");

        boolean found = roomService.existRoom(room);

        assertTrue(found);

    }

    @Test
    void addAnAvailableRoom() {

        assertThrows(RoomAlreadyExistsException.class, () -> {
            RoomService roomService = RoomService.getInstance();
            Room room = new Room(2, "name", "address");
            roomService.addRoom(2,"name", "address");
            roomService.addRoom(2,"name", "address");
        });

    }

    @Test
    void addRoomInvalidId() {

        assertThrows(RoomInvalidIdException.class, () -> {
            Room room = new Room(-1, "name", "address");
        });

    }

    @Test
    void addRoomWithoutAllFields() {

       assertThrows(RoomIncompleteFieldsException.class, () -> {
            Room room = new Room(null, "address");
       });

    }
}
