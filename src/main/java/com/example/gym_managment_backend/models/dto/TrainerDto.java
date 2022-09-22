package com.example.gym_managment_backend.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class TrainerDto {

    private String name;

    private String surname;

    private String address;

    private String phone_number;

    private List<Long> training_programIds;

    private List<Long> clientIds;

    public TrainerDto(String name, String surname, String address, String phone_number, List<Long> training_programIds, List<Long> clientIds) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone_number = phone_number;
        this.training_programIds = training_programIds;
        this.clientIds = clientIds;
    }
}
