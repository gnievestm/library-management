package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Room;
import com.teamcubation.librarymanagement.domain.exceptions.room.*;
import com.teamcubation.librarymanagement.domain.managers.RoomManager;
import com.teamcubation.librarymanagement.application.service.RoomService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RoomServiceTest {

    @Test
    void addRoom() throws RoomIncompleteFieldsException, RoomInvalidIdException, RoomAlreadyExistsException {

        RoomService roomService = new RoomService();
        Room room = new Room("name", "address");
        roomService.addRoom("name", "address");

        boolean found = roomService.existRoom(room);

        assertTrue(found);
    }

    @Test
    void addAnAvailableRoom() {

        assertThrows(RoomAlreadyExistsException.class, () -> {
            RoomService roomService = new RoomService();
            Room room = new Room("name", "address");
            roomService.addRoom("name", "address");
            roomService.addRoom("name", "address");
        });

    }

    @Test
    void addRoomWithoutAllFields() {

        assertThrows(RoomIncompleteFieldsException.class, () -> {
            Room room = new Room(null, "address");
        });

    }

    @Test
    void listRooms() throws RoomIncompleteFieldsException, RoomInvalidIdException, RoomNotFoundException, RoomAlreadyReservedException, RoomAlreadyExistsException {

        List<Room> testAvailableRooms = new ArrayList<>();
        Room room1 = new Room("name", "address");
        Room room2 = new Room("name2", "address");

        testAvailableRooms.add(room2);

        RoomManager roomManager = new RoomManager();
        roomManager.addRoom(room1);
        roomManager.addRoom(room2);

        roomManager.reserveRoom(room1);

        List<Room> testReservedRooms = new ArrayList<>();
        testReservedRooms.add(room1);

        assertEquals(testAvailableRooms, roomManager.getAvailableRooms());
        assertEquals(testReservedRooms, roomManager.getReservedRooms());

    }

    @Test
    void listAvailableRoomsWithoutRooms() {

        RoomManager roomManager = new RoomManager();
        int expected = 0;
        assertEquals(0, roomManager.getAvailableRooms().size());

    }
}
