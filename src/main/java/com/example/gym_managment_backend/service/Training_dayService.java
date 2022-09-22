package com.example.gym_managment_backend.service;

import com.example.gym_managment_backend.models.Exercise;
import com.example.gym_managment_backend.models.Training_day;
import com.example.gym_managment_backend.models.dto.Training_dayDto;
import com.example.gym_managment_backend.repository.ExerciseRepo;
import com.example.gym_managment_backend.repository.Training_dayRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Training_dayService {

    private final Training_dayRepo training_dayRepo;
    private final ExerciseRepo exerciseRepo;

    public List<Training_day> getAllTraining_days() {
        return this.training_dayRepo.findAll();
    }

    public Training_day getTraining_day(Long id) {
        return this.training_dayRepo.findById(id).get();
    }

    public Training_day saveTraining_day(Training_dayDto training_dayDto) {
        List<Exercise> exercises = this.exerciseRepo.findAllById(training_dayDto.getExercisesIds());
        Training_day training_day = new Training_day(training_dayDto.getName(), exercises, training_dayDto.getName_day());
        return this.training_dayRepo.save(training_day);
    }

    public void deleteTraining_day(Long id) {
        this.training_dayRepo.deleteById(id);
    }


}
