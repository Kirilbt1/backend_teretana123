package com.example.gym_managment_backend.models.dto;

import com.example.gym_managment_backend.models.enums.Days;
import lombok.Data;

import java.util.List;

@Data
public class Training_dayDto {

    private String name;
    private List<Long> exercisesIds;

    private Days name_day;

    public Training_dayDto(String name,List<Long> exercisesIds, Days name_day) {
        this.name = name;
        this.exercisesIds = exercisesIds;
        this.name_day = name_day;
    }
}
