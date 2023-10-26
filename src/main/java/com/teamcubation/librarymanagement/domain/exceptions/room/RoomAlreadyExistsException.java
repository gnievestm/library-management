package com.teamcubation.librarymanagement.domain.exceptions.room;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RoomAlreadyExistsException extends Exception {

    public RoomAlreadyExistsException () {
        super("The room already exists");
    }
}
