package com.hotel.service.service.impl;

import com.hotel.service.entity.Hotel;
import com.hotel.service.exceptions.ResourceNotFoundException;
import com.hotel.service.repositories.HotelRepository;
import com.hotel.service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelRepository hotelRepository;

    /*@Autowired
    HotelServiceImpl(HotelRepository hotelRepository){
        this.hotelRepository=hotelRepository;
    }*/

    @Override
    public Hotel createHotel(Hotel hotel) {
        String id = UUID.randomUUID().toString();
        hotel.setHotelId(id);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Requested Resource Can not be found on server "+id)
        );
    }

    @Override
    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }
}
