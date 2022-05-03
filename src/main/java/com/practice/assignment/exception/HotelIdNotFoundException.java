package com.practice.assignment.exception;

public class HotelIdNotFoundException extends RuntimeException{

    public HotelIdNotFoundException(String message) {
        super(message);
    }

}
