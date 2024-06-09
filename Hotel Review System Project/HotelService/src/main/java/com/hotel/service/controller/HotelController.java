package com.hotel.service.controller;

import com.hotel.service.entity.Hotel;
import com.hotel.service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return new ResponseEntity<>(hotelService.createHotel(hotel), HttpStatus.CREATED);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable("hotelId") String id){
        return ResponseEntity.ok(hotelService.getHotel(id));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getHotels(){
        return ResponseEntity.ok(hotelService.getHotels());
    }
}
