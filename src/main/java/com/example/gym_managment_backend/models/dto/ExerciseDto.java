package com.example.gym_managment_backend.models.dto;

import lombok.Data;

@Data
public class ExerciseDto {
    private String name;
    private String url_picture;

    private String url_video;

    private String description;

    public ExerciseDto(String name,String url_picture, String url_video, String description) {
        this.name = name;
        this.url_picture = url_picture;
        this.url_video = url_video;
        this.description = description;
    }
}
