package com.practice.assignment.Service;

import java.util.List;
import java.util.Optional;

import com.practice.assignment.Repository.HotelRepo;
import com.practice.assignment.exception.HotelIdNotFoundException;
import com.practice.assignment.exception.RoomNumberExceedsException;
import com.practice.assignment.model.Hotel;
import com.practice.assignment.model.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    @Autowired
    HotelRepo repo;

    public List<Hotel> getAllHotels() {
        Sort sort = Sort.by(Sort.Direction.DESC, "roomcount");
        return repo.findAll(sort);
    }

    public Hotel getHotel(int id) {
        Optional<Hotel> hotel = repo.findById(id);
        if (!hotel.isPresent()) {
            throw new HotelIdNotFoundException("Hotel id not Found in Database");
        }
        Hotel hotel2 = hotel.get();
        return hotel2;

    }

    public Hotel createHotel(Hotel hotel) {
        Hotel hotel1 = repo.save(hotel);
        return hotel1;
    }

    public Hotel createRoom(int id, List<Room> room) {
        int roomavailable = 0;
        for (Room r : room) {
            int count = r.getRoomcount();
            roomavailable += count;
        }
        Optional<Hotel> hotel = repo.findById(id);
        if (!hotel.isPresent()) {
            throw new HotelIdNotFoundException("Hotel id not Found in Database");
        }
        Hotel hotel2 = hotel.get();
        if (hotel2.getRoomcount() < roomavailable) {
            throw new RoomNumberExceedsException(
                    "Number of rooms count must be equal or less than total number of Hotel's room");
        }
        hotel2.getRooms().addAll(room);
        Hotel hotel1 = repo.save(hotel2);
        return hotel1;
    }

    public List<Room> retrieveRoom(int id) {
        Optional<Hotel> hotel = repo.findById(id);
        if (!hotel.isPresent()) {
            throw new HotelIdNotFoundException("Hotel id not Found in Database");
        }
        Hotel hotel2 = hotel.get();
        return hotel2.getRooms();
    }

    public Hotel updateRoomCost(int hid, int rid, double cost) {
        Optional<Hotel> hotel = repo.findById(hid);
        if (!hotel.isPresent()) {
            throw new HotelIdNotFoundException("Hotel id not Found in Database");
        }
        Hotel hotel2 =hotel.get();
        List<Room>rooms=hotel2.getRooms();
        for (Room room : rooms) {
            if(room.getId()==rid){
                room.setCost(cost);
            }
        }
         repo.save(hotel2);
        return hotel2;
    }
}
