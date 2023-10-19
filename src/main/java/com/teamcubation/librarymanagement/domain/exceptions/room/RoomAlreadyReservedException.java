package com.teamcubation.librarymanagement.domain.exceptions.room;

public class RoomAlreadyReservedException extends Exception {

    public RoomAlreadyReservedException () {
        super("The room it's already reserved");
    }
}
