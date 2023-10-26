package com.teamcubation.librarymanagement.domain.entities;

import com.teamcubation.librarymanagement.domain.exceptions.room.RoomIncompleteFieldsException;
import com.teamcubation.librarymanagement.domain.exceptions.room.RoomInvalidIdException;

import java.util.Objects;

public class Room {
    private static int roomIds = 0;
    private final String name;
    private final String address;
    private final int id;

    public Room(int id, String name, String address) throws RoomIncompleteFieldsException, RoomInvalidIdException {


        if (name == null || address == null || name.isEmpty() || address.isEmpty()) {
            throw new RoomIncompleteFieldsException();
        }

        this.name = name;
        this.address = address;

        if (id <= 0) {
            throw new RoomInvalidIdException();
        } else {
            this.id = id;
        }

    }

    public Room(String name, String address) throws RoomIncompleteFieldsException {


        if (name == null || address == null || name.isEmpty() || address.isEmpty()) {
            throw new RoomIncompleteFieldsException();
        }

        this.name = name;
        this.address = address;
        this.id = Room.roomIds++;

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, id);
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                '}';
    }
}
