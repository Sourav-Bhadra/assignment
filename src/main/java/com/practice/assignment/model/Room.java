package com.practice.assignment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room{
    private int roomcount;
    private double cost;
    private String type;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Room(){}
    public Room(String type,int roomcount,double cost){
        this.type=type;
        this.roomcount=roomcount;
        this.cost=cost;
    }

    public int getId(){
        return id;
    }

    public int getRoomcount() {
		return roomcount;
	}

	public void setRoomcount(int roomcount) {
		this.roomcount= roomcount;
	}

    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type=type;
    }
     public double getCost(){
        return cost;
    }
    public void setCost(double cost) {
		this.cost= cost;
	}
    

}