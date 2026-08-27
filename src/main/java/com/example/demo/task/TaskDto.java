package com.example.demo.task;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class TaskDto {

    private Long id;
    private String title;
    private String description;
    private boolean completed;

    public TaskDto(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.completed = task.isCompleted();
    }

}
