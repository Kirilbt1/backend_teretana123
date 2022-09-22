package com.example.gym_managment_backend.controllers;

import com.example.gym_managment_backend.models.Trainer;
import com.example.gym_managment_backend.models.dto.TrainerDto;
import com.example.gym_managment_backend.service.TrainerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainers")
@AllArgsConstructor
public class TrainerController {

    private final TrainerService trainerService;

    @GetMapping()
    public List<Trainer> getAllTrainers() {
        return this.trainerService.getAllTrainers();
    }

    @GetMapping("/{id}")
    public Trainer getTrainer(@PathVariable Long id) {
        return this.trainerService.getTrainerById(id);
    }

    @PostMapping("/save")
    public Trainer saveTrainer(@RequestBody TrainerDto trainerDto) {
        return this.trainerService.saveTrainer(trainerDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTrainer(@PathVariable Long id) {
        this.trainerService.deleteTrainer(id);
    }
}
