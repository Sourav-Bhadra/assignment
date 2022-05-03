package com.practice.assignment;

import java.util.ArrayList;
import java.util.List;

import com.practice.assignment.Service.HotelService;
import com.practice.assignment.model.Hotel;
import com.practice.assignment.model.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class AssignmentApplication implements CommandLineRunner{
	@Autowired
	HotelService service;

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Hotel hotel = new Hotel("Taj",10);
		Room room1 = new Room("Delux",6,1500.00);
		Room room2 = new Room("SemiLuxury", 6, 2000.00);
		Room room3=new Room("Luxary",3,2500.00);
		List<Room> rooms = new ArrayList<>();
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);
		hotel.setRooms(rooms);
		//service.createHotel(hotel);
	}

}
