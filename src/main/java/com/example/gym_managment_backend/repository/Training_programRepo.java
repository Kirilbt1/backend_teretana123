package com.example.gym_managment_backend.repository;

import com.example.gym_managment_backend.models.Training_program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Training_programRepo extends JpaRepository<Training_program,Long> {
}
