package com.example.demo.task;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/all")
    public List<Task> getAll() {
        return taskService.getAll();
    }

    // get by id
    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getById(@PathVariable Long id) {
        TaskDto task = taskService.findById(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(task);
    }

//    @GetMapping("/add")
//    public String add(Model model) {
//        model.addAttribute("task", new Task());
//        return "tasks/add";
//    }

    @PostMapping("/add")
    public ResponseEntity<TaskDto> create(@RequestBody Task task) {
        taskService.save(task);
        return ResponseEntity.status(201).body(new TaskDto(task));
    }

    // aktualizuj zad
    @PutMapping("/update/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id,
                                       @RequestBody Task updated) {

        Task task = taskService.findTasksById(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }

        task.setTitle(updated.getTitle());
        task.setDescription(updated.getDescription());
        taskService.save(task);
        return  ResponseEntity.ok(task);
    }

    @PatchMapping("/status/{id}/complete")
    public ResponseEntity<Task> complete(@PathVariable Long id) {
        Task task = taskService.findTasksById(id);

        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        task.setCompleted(true);
        taskService.save(task);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (!taskService.exists(id)) {
            return  ResponseEntity.notFound().build();
        }
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
