package com.example.gym_managment_backend.service;

import com.example.gym_managment_backend.models.Exercise;
import com.example.gym_managment_backend.repository.ExerciseRepo;
import lombok.AllArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExerciseService {

    private final ExerciseRepo exerciseRepo;

    public List<Exercise> getAllExercises() {
        return this.exerciseRepo.findAll();
    }

    public Exercise findExerciseById(Long id){
        return this.exerciseRepo.findById(id).get();
    }

    public void saveExercise(String name,String url_picture, @Nullable String url_video, String description) {
        Exercise exercise = new Exercise(name,url_picture,url_video,description);
        this.exerciseRepo.save(exercise);
    }

    public void deleteExercise(Long id){
        this.exerciseRepo.deleteById(id);
    }
}
