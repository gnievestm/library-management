package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Room;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomIncompleteFieldsException;
import com.teamcubation.librarymanagement.service.RoomService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class RoomServiceTest {

    @Test
    void addRoom() throws RoomIncompleteFieldsException {
        RoomService roomService = RoomService.getInstance();
        roomService.addRoom("name", "address");
        Room room = new Room("name", "address");

        boolean found = roomService.existRoom(room);

        assertTrue(found);
    }

    @Test
    void addRoomWithoutAllField() throws RoomIncompleteFieldsException {

       assertThrows(RoomIncompleteFieldsException.class, () -> {
            RoomService roomService = RoomService.getInstance();
            Room room = new Room(null, "address");
            roomService.addRoom(room.getName(), room.getAddress());
       });

    }
}
