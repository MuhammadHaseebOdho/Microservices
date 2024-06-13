package com.user.service.external;

import com.user.service.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RatingsService")
public interface RatingService {

    @GetMapping("/rating/{userId}/user")
    List<Rating> getRatingByUser(@PathVariable String userId );
}
