package com.teamcubation.librarymanagement.domain.managers;

import com.teamcubation.librarymanagement.domain.entities.Room;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomIncompleteFieldsException;

import java.util.ArrayList;
import java.util.List;
public class RoomManager {

    private List<Room> rooms;

    public RoomManager(){
       rooms = new ArrayList<>();
    }

    public boolean addRoom(Room room) throws RoomIncompleteFieldsException {
        if(rooms.contains(room)){
            return false;
        }

        if(room.getName() == null || room.getId() == 0 || room.getAddress() == null){
            throw new RoomIncompleteFieldsException();
        }

        rooms.add(room);
        return true;
    }
}
