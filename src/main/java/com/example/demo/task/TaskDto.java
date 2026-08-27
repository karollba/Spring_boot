package com.example.demo.task;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
public class TaskDto {

    private Long id;
    private String title;
    private String description;
    private boolean completed;

    public TaskDto(Long id, String title, String description, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }
}
