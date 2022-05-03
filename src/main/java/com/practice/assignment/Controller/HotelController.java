package com.practice.assignment.Controller;

import java.util.Arrays;
import java.util.List;

import com.practice.assignment.Service.HotelService;
import com.practice.assignment.model.Hotel;
import com.practice.assignment.model.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class HotelController {

    @Autowired
    HotelService service;

    @GetMapping("/hotel")
    public ResponseEntity<List<Hotel>> getHotels() {
        return new ResponseEntity<List<Hotel>>(service.getAllHotels(), HttpStatus.OK);
    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable int id) {
        return new ResponseEntity<Hotel>(service.getHotel(id), HttpStatus.FOUND);
    }

    @PostMapping("/hotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        return new ResponseEntity<Hotel>(service.createHotel(hotel), HttpStatus.CREATED);
    }

    @PostMapping("/hotel/{id}/rooms")
    public ResponseEntity<Hotel> createRoom(@PathVariable int id, @RequestBody Room[] room){
        List<Room> rooms = Arrays.asList(room);
        return new ResponseEntity<Hotel>(service.createRoom(id,rooms), HttpStatus.CREATED);
    }
    
    @GetMapping("/hotel/{id}/rooms")
    public ResponseEntity<List<Room>> createRoom(@PathVariable int id) {
        return new ResponseEntity<List<Room>>(service.retrieveRoom(id), HttpStatus.FOUND);
    }

    @PutMapping("/hotel/{hid}/rooms/{rid}/{cost}")
    public ResponseEntity<Hotel> updateRoomCost(@PathVariable int hid,@PathVariable int rid, @PathVariable double cost){
        return new ResponseEntity<Hotel>(service.updateRoomCost(hid, rid, cost), HttpStatus.OK);
    }
}
