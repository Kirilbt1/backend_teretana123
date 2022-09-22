package com.example.gym_managment_backend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String address;

    private String phone_number;

    @OneToMany
    @NotNull
    private List<Training_program> training_programs;

    @OneToMany(mappedBy = "trainer")
    @JsonManagedReference
    private List<Client> clients;

    public Trainer() {
        training_programs = new ArrayList<>();
        clients = new ArrayList<>();
    }

    public Trainer(String name, String surname, String address, String phone_number, List<Training_program> training_programs, List<Client> clients) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone_number = phone_number;
        if(training_programs == null){
            this.training_programs = new ArrayList<>();
        }
        else{
            this.training_programs = training_programs;
        }
        if(clients == null){
            this.clients = new ArrayList<>();
        }
        else{
            this.clients = clients;
        }
    }
}
