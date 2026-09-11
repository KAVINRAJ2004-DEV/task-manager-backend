package com.devops.taskmanager;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {
    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Task> getTasks() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        if (task.title() == null || task.title().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(repository.save(task));
    }

    @GetMapping("/health")
    public String health() {
        return "Task Manager backend is healthy";
    }
}
