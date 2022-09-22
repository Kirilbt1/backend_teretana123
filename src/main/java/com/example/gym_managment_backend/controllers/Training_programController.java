package com.example.gym_managment_backend.controllers;

import com.example.gym_managment_backend.models.Training_program;
import com.example.gym_managment_backend.models.dto.Training_programDto;
import com.example.gym_managment_backend.service.Training_programService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainingPrograms")
@AllArgsConstructor
public class Training_programController {

    private final Training_programService training_programService;

    @GetMapping()
    public List<Training_program> getAllTrainingPrograms() {
        return this.training_programService.getAllTrainingPrograms();
    }

    @GetMapping("/{id}")
    public Training_program getTrainingProgram(@PathVariable Long id) {
        return this.training_programService.getTrainingProgram(id);
    }

    @PostMapping("/save")
    public Training_program saveTrainingProgram(@RequestBody Training_programDto training_programDto){
        return this.training_programService.saveTraining_program(training_programDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTrainingProgram(@PathVariable Long id) {
        this.training_programService.deleteTrainingProgram(id);
    }
}
