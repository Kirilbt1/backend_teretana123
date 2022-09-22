package com.example.gym_managment_backend.service;

import com.example.gym_managment_backend.models.Client;
import com.example.gym_managment_backend.models.Trainer;
import com.example.gym_managment_backend.models.Training_program;
import com.example.gym_managment_backend.models.dto.TrainerDto;
import com.example.gym_managment_backend.repository.ClientRepo;
import com.example.gym_managment_backend.repository.TrainerRepo;
import com.example.gym_managment_backend.repository.Training_programRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TrainerService {

    private final TrainerRepo trainerRepo;
    private final ClientRepo clientRepo;
    private final Training_programRepo training_programRepo;

    public List<Trainer> getAllTrainers() {
        return this.trainerRepo.findAll();
    }

    public Trainer getTrainerById(Long id) {
        return this.trainerRepo.findById(id).get();
    }

    public Trainer saveTrainer(TrainerDto trainerDto) {
        List<Client> clients = this.clientRepo.findAllById(trainerDto.getClientIds());
        List<Training_program> training_programs = this.training_programRepo.findAllById(trainerDto.getTraining_programIds());
        Trainer trainer = new Trainer(trainerDto.getName(), trainerDto.getSurname(), trainerDto.getAddress(), trainerDto.getPhone_number(),
                training_programs, clients);
        return this.trainerRepo.save(trainer);
    }

    public void deleteTrainer(Long id) {
        this.trainerRepo.deleteById(id);
    }
}
