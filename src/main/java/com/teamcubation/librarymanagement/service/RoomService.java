package com.teamcubation.librarymanagement.service;

import com.teamcubation.librarymanagement.domain.entities.Room;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomIncompleteFieldsException;
import com.teamcubation.librarymanagement.domain.managers.RoomManager;

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

    public void addRoom(String name, String address) throws RoomIncompleteFieldsException {
        Room room = new Room(name,address);
        this.roomManager.addRoom(room);
    }

    public boolean existRoom(Room room){
        return roomManager.existRoom(room);
    }

}
