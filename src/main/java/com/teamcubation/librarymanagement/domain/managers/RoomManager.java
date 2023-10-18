package com.teamcubation.librarymanagement.domain.managers;

import com.teamcubation.librarymanagement.domain.entities.Room;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomIncompleteFieldsException;

import java.util.ArrayList;
import java.util.List;
public class RoomManager {

    private List<Room> rooms;
    private List<Room> reservedRooms;

    public RoomManager(){
       rooms = new ArrayList<>();
       reservedRooms = new ArrayList<>();
    }

    public boolean existRoom(Room room){
        return rooms.contains(room) || reservedRooms.contains(room);
    }

    public boolean addRoom(Room room) throws RoomIncompleteFieldsException {
        if(rooms.contains(room)){
            return false;
        }

        if(room.getName() == null || room.getAddress() == null || room.getName().isEmpty() || room.getAddress().isEmpty()){
            throw new RoomIncompleteFieldsException();
        }

        rooms.add(room);
        return true;
    }

    public boolean reserveRoom(Room room) throws RoomIncompleteFieldsException {
        if(reservedRooms.contains(room)){
            return false;
        }

        if(room.getName() == null || room.getAddress() == null){
            throw new RoomIncompleteFieldsException();
        }

        reservedRooms.add(room);
        rooms.remove(room);
        return true;
    }
}
