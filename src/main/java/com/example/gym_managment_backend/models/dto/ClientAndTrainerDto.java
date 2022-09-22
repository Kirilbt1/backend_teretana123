package com.example.gym_managment_backend.models.dto;

import com.example.gym_managment_backend.models.Client;
import com.example.gym_managment_backend.models.Trainer;
import lombok.Data;

@Data
public class ClientAndTrainerDto {

    private Client client;

    private Trainer trainer;


    public ClientAndTrainerDto(Client client, Trainer trainer) {
        this.client = client;
        this.trainer = trainer;
    }
}
