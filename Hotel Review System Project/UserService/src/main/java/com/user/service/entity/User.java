package com.user.service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    private String userId;
    private String username;
    private String about;
    private String email;
    @Transient
    private List<Rating> ratings;

}
