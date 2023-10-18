package com.teamcubation.librarymanagement.domain.entities;

import java.util.Objects;

public class Room {
    private static int roomIds=0;
    private String name;
    private String address;
    private int id;

    public Room(String name, String address) {
        this.name = name;
        this.address = address;
        this.id = Room.roomIds++;
    }

    public int getRoomIds() {
        return roomIds;
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
}
