package com.hotel.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hotels")
@Data
@NoArgsConstructor
public class Hotel {
    @Id
    private String hotelId;
    private String hotelName;
    private String about;
    private String location;
}
