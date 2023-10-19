package com.teamcubation.librarymanagement.domain.exceptions.room;

public class RoomAlreadyExistsException extends Exception {

    public RoomAlreadyExistsException () {
        super("The room already exists");
    }
}
