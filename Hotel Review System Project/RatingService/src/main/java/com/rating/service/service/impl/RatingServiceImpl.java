package com.rating.service.service.impl;

import com.rating.service.entity.Rating;
import com.rating.service.exceptions.ResourceNotFoundException;
import com.rating.service.repositories.RatingRepository;
import com.rating.service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    RatingRepository ratingRepository;
    @Override
    public Rating createRating(Rating rating) {
        String id = UUID.randomUUID().toString();
        rating.setRatingId(id);
        return ratingRepository.save(rating) ;
    }

    @Override
    public Rating getRating(String ratingId) {
        return ratingRepository.findById(ratingId).orElseThrow(()-> new ResourceNotFoundException("Sorry, Requested Resource can not be found on server."+ratingId));
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingsByUser(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByHotel(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
