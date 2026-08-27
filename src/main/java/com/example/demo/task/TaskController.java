package com.example.demo.task;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/all")
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    // get by id
    @GetMapping("/{id}")
    public ResponseEntity<Task> getById(@PathVariable Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(task);
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("task", new Task());
        return "tasks/add";
    }

    @PostMapping("/add")
    public ResponseEntity<Task> create(@RequestBody Task task) {
        taskRepository.save(task);
        return ResponseEntity.status(201).body(task);
    }



    // aktualizuj zad
    @PutMapping("/update/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id,
                                       @RequestBody Task updated) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }

        task.setTitle(updated.getTitle());
        task.setDescription(updated.getDescription());
        taskRepository.save(task);
        return  ResponseEntity.ok(task);
    }

    @PatchMapping("/status/{id}/complete")
    public ResponseEntity<Task> complete(@PathVariable Long id) {
        Task task = taskRepository.findById(id).orElse(null);

        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        task.setCompleted(true);
        taskRepository.save(task);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (!taskRepository.existsById(id)) {
            return  ResponseEntity.notFound().build();
        }
        taskRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
