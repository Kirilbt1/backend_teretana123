package com.example.gym_managment_backend.repository;

import com.example.gym_managment_backend.models.Client;
import com.example.gym_managment_backend.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {

    Client findClientByTrainer(Trainer trainer);
}
