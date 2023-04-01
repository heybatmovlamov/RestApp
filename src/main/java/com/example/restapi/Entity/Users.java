package com.example.restapi.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Data
@Entity()
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String occupation;
}
