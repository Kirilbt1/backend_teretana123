package com.example.gym_managment_backend.models;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String url_picture;

    @Nullable
    private String url_video;

    private String description;

    public Exercise() {

    }

    public Exercise(String name, String url_picture, @Nullable String url_video, String description) {
        this.name = name;
        this.url_picture = url_picture;
        this.url_video = url_video;
        this.description = description;
    }
}
