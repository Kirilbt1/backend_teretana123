package com.example.gym_managment_backend.repository;

import com.example.gym_managment_backend.models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepo extends JpaRepository<Exercise,Long> {
}
