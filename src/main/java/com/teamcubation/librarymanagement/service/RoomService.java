package com.teamcubation.librarymanagement.service;

import com.teamcubation.librarymanagement.domain.entities.Room;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomAlreadyExistsException;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomIncompleteFieldsException;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomInvalidIdException;
import com.teamcubation.librarymanagement.domain.managers.RoomManager;

import java.util.List;

public class RoomService {

    static RoomService instance;
    private RoomManager roomManager;
    public static RoomService getInstance(){
        if(instance == null)
            instance = new RoomService();
        return instance;
    }

    private RoomService(){
        this.roomManager = new RoomManager();
    }

    public void addRoom(int id, String name, String address) throws RoomIncompleteFieldsException, RoomInvalidIdException, RoomAlreadyExistsException {
        Room room = new Room(id, name, address);
        this.roomManager.addRoom(room);
    }

    public boolean existRoom(Room room){
        return roomManager.existRoom(room);
    }

}
