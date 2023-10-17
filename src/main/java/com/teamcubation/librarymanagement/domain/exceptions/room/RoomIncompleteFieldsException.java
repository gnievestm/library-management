package com.teamcubation.librarymanagement.domain.exceptions.room;

public class RoomIncompleteFieldsException extends Exception{

    public RoomIncompleteFieldsException(){
        super("Some required fields are incomplete");
    }
}
