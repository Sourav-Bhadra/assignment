package com.practice.assignment.Repository;

import com.practice.assignment.model.Hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface HotelRepo extends JpaRepository<Hotel,Integer>{
    
}
