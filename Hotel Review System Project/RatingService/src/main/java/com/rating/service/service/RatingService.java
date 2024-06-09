package com.rating.service.service;

import com.rating.service.entity.Rating;


import java.util.List;

public interface RatingService {
    Rating createRating(Rating rating);
    Rating getRating(String ratingId);
    List<Rating> getRatings();
    List<Rating> getRatingsByUser(String userId);
    List<Rating> getRatingsByHotel(String hotelId);

}
