package com.example.gym_managment_backend.models;

import com.example.gym_managment_backend.models.enums.Experience;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String address;

    private String phone_number;

    @Enumerated(EnumType.STRING)
    private Experience experience;

    @ManyToOne
    @JsonBackReference
    private Trainer trainer;

    @ManyToOne
    private Training_program training_program;

    public Client() {
    }

    public Client(String name, String surname, String address, String phone_number, Experience experience,Trainer trainer,Training_program training_program) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone_number = phone_number;
        this.experience = experience;
        this.trainer = trainer;
        this.training_program = training_program;
    }
}
