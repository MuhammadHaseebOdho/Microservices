package com.rating.service.controller;

import com.rating.service.entity.Rating;
import com.rating.service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return new ResponseEntity<>(ratingService.createRating(rating), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRatings(){
        return ResponseEntity.ok(ratingService.getRatings());
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRating(@PathVariable("ratingId") String ratingId){
        return ResponseEntity.ok(ratingService.getRating(ratingId));
    }
    @GetMapping("/{userId}/user")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable("userId") String userId){
        return ResponseEntity.ok(ratingService.getRatingsByUser(userId));
    }

    @GetMapping("/{hotelId}/hotel")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable("hotelId") String hotelId){
        return ResponseEntity.ok(ratingService.getRatingsByHotel(hotelId));
    }
}
