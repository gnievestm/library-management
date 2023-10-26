package com.teamcubation.librarymanagement.application.service;

import com.teamcubation.librarymanagement.application.port.in.IRoomPort;
import com.teamcubation.librarymanagement.domain.entities.Room;
import com.teamcubation.librarymanagement.domain.exceptions.room.*;
import com.teamcubation.librarymanagement.domain.managers.RoomManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService implements IRoomPort {

    private final RoomManager roomManager;
    
    public RoomService() {
        this.roomManager = new RoomManager();
    }

    public void addRoom(int id, String name, String address) throws RoomIncompleteFieldsException, RoomInvalidIdException, RoomAlreadyExistsException {
        Room room = new Room(id, name, address);
        this.roomManager.addRoom(room);
    }

    public boolean existRoom(Room room) {
        return roomManager.existRoom(room);
    }

    @Override
    public List<Room> getAllRooms() {
        List <Room> rooms = new ArrayList<>();
        rooms.addAll(this.roomManager.getAvailableRooms());
        rooms.addAll(this.roomManager.getReservedRooms());
        return rooms;
    }

    @Override
    public void createRoom(Room room) throws RoomAlreadyExistsException {
        this.roomManager.addRoom(room);
    }

    @Override
    public void reserveRoom(Room room) {
    }
}
