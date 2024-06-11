package com.user.service.service.impl;

import com.user.service.entity.Hotel;
import com.user.service.entity.Rating;
import com.user.service.entity.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.repositories.UserRepository;
import com.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        String id = UUID.randomUUID().toString();
        user.setUserId(id);
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        List<User> userList = userRepository.findAll();
        List<User> collected = userList.stream().map(user -> {
            String ratingUrl = "http://RatingsService/rating/" + user.getUserId() + "/user";
            ResponseEntity<Rating[]> body = restTemplate.getForEntity(ratingUrl, Rating[].class);
            Rating[] ratingList = body.getBody();
            List<Rating> list = Arrays.stream(ratingList).toList();
            List<Rating> collectedList = list.stream().map(rating -> {
                String hotelUrl = "http://HotelService/hotel/" + rating.getHotelId();
                Hotel hotel = restTemplate.getForObject(hotelUrl, Hotel.class);
                rating.setHotel(hotel);
                return rating;
            }).collect(Collectors.toList());
            user.setRatings(collectedList);
            return user;
        }).collect(Collectors.toList());
        return collected;
    }

    @Override
    public User getUser(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Requested Resource Can not be found on server" + id));
        String ratingUrl = "http://RatingsService/rating/" + id + "/user";
        ResponseEntity<Rating[]> body = restTemplate.getForEntity(ratingUrl, Rating[].class);
        Rating[] ratingList = body.getBody();
        List<Rating> list = Arrays.stream(ratingList).toList();
        List<Rating> ratings = list.stream().map(rating -> {
            String hotelUrl = "http://HotelService/hotel/" + rating.getHotelId();
            Hotel hotel = restTemplate.getForObject(hotelUrl, Hotel.class);
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratings);
        return user;
    }

    @Override
    public User updateUser() {
        return null;
    }

    @Override
    public void deleteUser() {

    }
}
