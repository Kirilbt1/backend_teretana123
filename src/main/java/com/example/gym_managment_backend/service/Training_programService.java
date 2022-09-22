package com.example.gym_managment_backend.service;

import com.example.gym_managment_backend.models.Training_day;
import com.example.gym_managment_backend.models.Training_program;
import com.example.gym_managment_backend.models.dto.Training_programDto;
import com.example.gym_managment_backend.repository.Training_dayRepo;
import com.example.gym_managment_backend.repository.Training_programRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Training_programService {

    private final Training_programRepo training_programRepo;
    private final Training_dayRepo training_dayRepo;

    public List<Training_program> getAllTrainingPrograms() {
        return this.training_programRepo.findAll();
    }

    public Training_program getTrainingProgram(Long id) {
        return this.training_programRepo.findById(id).get();
    }

    public Training_program saveTraining_program(Training_programDto training_programDto) {
        List<Training_day> training_days = this.training_dayRepo.findAllById(training_programDto.getTraining_daysIds());
        Training_program training_program = new Training_program(training_programDto.getName(), training_programDto.getDescription(),
                training_days);
        return this.training_programRepo.save(training_program);
    }

    public void deleteTrainingProgram(Long id) {
        this.training_programRepo.deleteById(id);
    }

}
