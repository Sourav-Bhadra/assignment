package com.practice.assignment.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int roomcount;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Room.class)
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private List<Room> rooms;

    public Hotel(String name, int roomcount) {
        this.name = name;

        this.roomcount = roomcount;
    }

    public Hotel() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRoomcount() {
        return roomcount;
    }

    public void setRoomcount(int roomcount) {
        this.roomcount = roomcount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Hotel [id=" + id + ", name=" + name + ", roomcount=" + roomcount + "]";
    }
}