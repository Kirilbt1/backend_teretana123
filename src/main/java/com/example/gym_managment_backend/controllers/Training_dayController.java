package com.example.gym_managment_backend.controllers;

import com.example.gym_managment_backend.models.Training_day;
import com.example.gym_managment_backend.models.dto.Training_dayDto;
import com.example.gym_managment_backend.service.Training_dayService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainingDays")
@AllArgsConstructor
public class Training_dayController {
    private final Training_dayService training_dayService;

    @GetMapping
    public List<Training_day> getAllTrainingDays() {
        return this.training_dayService.getAllTraining_days();
    }

    @GetMapping("/{id}")
    public Training_day getTrainingDay(@PathVariable Long id) {
        return this.training_dayService.getTraining_day(id);
    }

    @PostMapping("/save")
    public Training_day saveTrainingDay(@RequestBody Training_dayDto training_dayDto) {
        return this.training_dayService.saveTraining_day(training_dayDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTrainingDay(@PathVariable Long id) {
        this.training_dayService.deleteTraining_day(id);
    }
}
