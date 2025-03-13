package com.lcwd.user.service.UserService.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "micro_users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private String userId;

    @Column(name = "NAME", length = 25)
    private String userName;

    @Column(name = "EMAIL", unique = true)
    private String userEmail;

    @Column(name = "PHONE NUMBER", unique = true)
    private String userPhoneNo;

    @Transient          //means do not save in db
    private List<Rating> ratings = new ArrayList<>();

}
