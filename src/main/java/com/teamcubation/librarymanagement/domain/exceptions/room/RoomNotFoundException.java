package com.teamcubation.librarymanagement.domain.exceptions.room;

public class RoomNotFoundException extends Exception{

    public RoomNotFoundException(){
        super("Room not found");
    }
}
