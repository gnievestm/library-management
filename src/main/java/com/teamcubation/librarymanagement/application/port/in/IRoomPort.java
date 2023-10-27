package com.teamcubation.librarymanagement.application.port.in;

import com.teamcubation.librarymanagement.domain.entities.Room;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomAlreadyExistsException;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomAlreadyReservedException;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomNotFoundException;

import java.util.List;

public interface IRoomPort {
    List<Room> getAllRooms();
    void createRoom(Room room) throws RoomAlreadyExistsException;
    void reserveRoom(Room room) throws RoomNotFoundException, RoomAlreadyReservedException;
    void cancelBookRoom(Room room) throws RoomNotFoundException;
}
