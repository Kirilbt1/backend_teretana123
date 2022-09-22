package com.example.gym_managment_backend.controllers;

import com.example.gym_managment_backend.models.Exercise;
import com.example.gym_managment_backend.models.dto.ExerciseDto;
import com.example.gym_managment_backend.service.ExerciseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
@AllArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;

    @GetMapping()
    public List<Exercise> getAllExercises() {
        return this.exerciseService.getAllExercises();
    }

    @GetMapping("/{id}")
    public Exercise findExerciseById(@PathVariable Long id) {
        return this.exerciseService.findExerciseById(id);
    }

    @PostMapping("/save")
    public void saveExercise(@RequestBody ExerciseDto exerciseDto) {
        this.exerciseService.saveExercise(exerciseDto.getName(),exerciseDto.getUrl_picture(), exerciseDto.getUrl_video(), exerciseDto.getDescription());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteExercise(@PathVariable Long id) {
        this.exerciseService.deleteExercise(id);
    }

}
