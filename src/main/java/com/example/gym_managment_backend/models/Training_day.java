package com.example.gym_managment_backend.models;

import com.example.gym_managment_backend.models.enums.Days;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Training_day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private List<Exercise> exercises;

    @Enumerated(EnumType.STRING)
    private Days name_day;

    public Training_day() {
        exercises = new ArrayList<>();
    }

    public Training_day(String name, List<Exercise> exercises, Days name_day) {
        this.name = name;
        this.exercises = exercises;
        this.name_day = name_day;
    }
}
