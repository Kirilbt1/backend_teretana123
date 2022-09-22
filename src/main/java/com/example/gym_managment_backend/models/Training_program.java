package com.example.gym_managment_backend.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Training_program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany
    private List<Training_day> training_days;

    public Training_program() {
        training_days = new ArrayList<>();
    }

    public Training_program(String name,String description, List<Training_day> training_days) {
        this.name = name;
        this.description = description;
        this.training_days = training_days;
    }
}
