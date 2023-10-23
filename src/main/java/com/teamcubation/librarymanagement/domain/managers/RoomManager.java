package com.teamcubation.librarymanagement.domain.managers;

import com.teamcubation.librarymanagement.domain.entities.Room;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomAlreadyExistsException;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomAlreadyReservedException;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomNotFoundException;

import java.util.ArrayList;
import java.util.List;
public class RoomManager {

    private List<Room> availableRooms;
    private List<Room> reservedRooms;

    public RoomManager() {

        availableRooms = new ArrayList<>();
        reservedRooms = new ArrayList<>();
    }

    public boolean existRoom(Room room) {

        return availableRooms.contains(room) || reservedRooms.contains(room);
    }

    public boolean addRoom(Room room) throws RoomAlreadyExistsException {

        if (existRoom(room)) {
            throw new RoomAlreadyExistsException();
        }

        availableRooms.add(room);
        return true;
    }

    public List<Room> getAvailableRooms() {

        if (this.availableRooms.isEmpty()) {
            return null;
        }

        return this.availableRooms;
    }

    public List<Room> getReservedRooms() {

        if (this.reservedRooms.isEmpty()) {
            return null;
        }

        return this.reservedRooms;
    }

    public boolean reserveRoom (Room room) throws RoomNotFoundException, RoomAlreadyReservedException {

        if(reservedRooms.contains(room)){
            throw new RoomAlreadyReservedException();
        }

        if (availableRooms.contains(room)) {

            reservedRooms.add(room);
            availableRooms.remove(room);

            return true;

        } else {
            throw new RoomNotFoundException();
        }

    }
}