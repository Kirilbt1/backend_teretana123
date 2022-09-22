package com.example.gym_managment_backend.initializer;

import com.example.gym_managment_backend.models.*;
import com.example.gym_managment_backend.models.enums.Days;
import com.example.gym_managment_backend.models.enums.Experience;
import com.example.gym_managment_backend.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final ClientRepo clientRepo;
    private final ExerciseRepo exerciseRepo;
    private final Training_dayRepo training_dayRepo;
    private final Training_programRepo training_programRepo;
    private final TrainerRepo trainerRepo;


    @PostConstruct
    public void initialize() {
        Exercise exercise = new Exercise("Bench press","https://cdn.mos.cms.futurecdn.net/pLaRi5jXSHDKu6WRydetBo-1920-80.jpg.webp",null,"Exercise description");
        Exercise exercise1 = new Exercise("Overhead press" , "https://static.strengthlevel.com/images/illustrations/shoulder-press-1000x1000.jpg", "", "Overhead press");
        Training_day training_day = new Training_day("Chest day",List.of(exercise), Days.Monday);
        Training_program training_program = new Training_program("Train","Training program" , List.of(training_day));
        Trainer trainer = new Trainer("Marko" , "Markoski" , "Skopje" , "123456789" , List.of(training_program) , null);
        Client client = new Client("Marko","Markoski","Skopje","123456789", Experience.INTERMEDIATE,trainer,training_program);
        trainer.getClients().add(client);
        this.exerciseRepo.save(exercise);
        this.exerciseRepo.save(exercise1);
        this.training_dayRepo.save(training_day);
        this.training_programRepo.save(training_program);
        this.trainerRepo.save(trainer);
        this.clientRepo.save(client);
    }

}
