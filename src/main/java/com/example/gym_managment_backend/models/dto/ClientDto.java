package com.example.gym_managment_backend.models.dto;

import lombok.Data;

@Data
public class ClientDto {

    private String name;
    private String surname;
    private String address;
    private String phone_number;
    private String experience;
    private Long trainerId;
    private Long training_programId;

    public ClientDto(String name, String surname, String address, String phone_number, String experience, Long trainerId, Long training_programId) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone_number = phone_number;
        this.experience = experience;
        this.trainerId = trainerId;
        this.training_programId = training_programId;
    }
}
