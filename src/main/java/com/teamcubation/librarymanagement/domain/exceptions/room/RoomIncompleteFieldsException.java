package com.teamcubation.librarymanagement.domain.exceptions.room;

public class RoomIncompleteFieldsException extends Exception {

    public RoomIncompleteFieldsException() {
        super("The 'name' and 'address' fields are required");
    }
}
