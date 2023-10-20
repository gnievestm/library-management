package com.teamcubation.librarymanagement.domain;

import com.teamcubation.librarymanagement.domain.entities.Room;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomAlreadyExistsException;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomIncompleteFieldsException;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomInvalidIdException;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomNotFoundException;
import com.teamcubation.librarymanagement.domain.managers.RoomManager;
import com.teamcubation.librarymanagement.service.RoomService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
            roomService.addRoom(2, "name", "address");
            roomService.addRoom(2, "name", "address");
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

    @Test
    void listRooms() throws RoomIncompleteFieldsException, RoomInvalidIdException, RoomAlreadyExistsException, RoomNotFoundException {

        List<Room> testAvailableRooms = new ArrayList<>();
        Room room1 = new Room(1, "name", "address");
        Room room2 = new Room(2, "name", "address");

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

        assertNull(roomManager.getAvailableRooms());

    }

    @Test
    void reserveRoom() throws RoomInvalidIdException, RoomIncompleteFieldsException, RoomAlreadyExistsException, RoomNotFoundException {
        RoomManager roomManager = new RoomManager();
        Room room1 = new Room(1, "name", "address");

        roomManager.addRoom(room1);

        assertTrue(roomManager.reserveRoom(room1));

    }

    @Test
    void reserveRoomWithoutAvailableRooms() {

        assertThrows(RoomNotFoundException.class, () -> {
            RoomManager roomManager = new RoomManager();
            Room room1 = new Room(1, "name", "address");
            roomManager.reserveRoom(room1);
        });

    }
}
