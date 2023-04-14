package com.example.restapi.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity()
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private int age;
    @Column
    private String occupation;


}
