package com.teamcubation.librarymanagement.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomIncompleteFieldsException;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomInvalidIdException;

import java.util.Objects;

public class Room {

    private final String name;
    private final String address;

    public Room(String name, String address) throws RoomIncompleteFieldsException {

        if (name == null || address == null || name.isEmpty() || address.isEmpty()) {
            throw new RoomIncompleteFieldsException();
        }

        this.id = ++Room.roomIds;
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return name.equals(room.getName()) && address.equals(room.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

    @Override
    public String toString() {
        return "Room{" + "name='" + name + '\'' + ", address='" + address + '}';
    }
}
