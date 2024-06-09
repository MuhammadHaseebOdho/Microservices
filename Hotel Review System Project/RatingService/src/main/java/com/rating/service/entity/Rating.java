package com.rating.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ratings")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Rating {
    @Id
    private String ratingId;
    private String hotelId;
    private String userId;
    private int rating;
    private String feedback;

}
