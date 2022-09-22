package com.example.gym_managment_backend.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class Training_programDto {

    private String name;

    private String description;

    private List<Long> training_daysIds;


    public Training_programDto(String name, String description, List<Long> training_daysIds) {
        this.name = name;
        this.description = description;
        this.training_daysIds = training_daysIds;
    }
}
