package com.example.demo.task;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAll() {
        return repository.findAll();
    }

    public TaskDto putTask(TaskDto taskDto) {
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setCompleted(taskDto.isCompleted());
        repository.save(task);
        return taskDto;
    }
    
    public TaskDto findById(Long id) {
        Task task = repository.findById(id).orElse(null);
        if (task == null) {
            return null;
        }
        return new TaskDto(task);

    }

    public void save(Task task) {
        repository.save(task);

    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public boolean exists(Long id) {
        return repository.existsById(id);
    }

    public Task findTasksById(Long id) {
        return repository.findById(id).orElse(null);
    };


}
