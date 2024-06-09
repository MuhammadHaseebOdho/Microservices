package com.hotel.service.service;

import com.hotel.service.entity.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);

    Hotel getHotel(String id);

    List<Hotel> getHotels();
}
