package com.practice.assignment.Repository;

import com.practice.assignment.model.Hotel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel,Integer>{
    
}
