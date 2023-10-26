package com.teamcubation.librarymanagement.application.port.in;

import com.teamcubation.librarymanagement.domain.entities.Room;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomAlreadyExistsException;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomAlreadyReservedException;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomNotFoundException;

import java.util.List;

public interface IRoomPort {
    public List<Room> getAllRooms();
    public void createRoom(Room room) throws RoomAlreadyExistsException;
    public void reserveRoom(Room room) throws RoomNotFoundException, RoomAlreadyReservedException;

}
