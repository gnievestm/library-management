package com.teamcubation.librarymanagement.domain.exceptions.room;

public class RoomInvalidIdException extends Exception {

    public RoomInvalidIdException () {
        super("The ID must be a positive number");
    }
}
