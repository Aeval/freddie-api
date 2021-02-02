package com.freddie.todoapi;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping
    public void insert(@RequestBody Task task) {
        final String username = SecurityContextHolder.getContext().getAuthentication().getName();
        task.setUsername(username);
        this.taskRepository.insert(task);
    }

    @PutMapping
    public void update(@RequestBody Task task) {
        this.taskRepository.save(task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.taskRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Task> getById(@PathVariable("id") String id) {
        Optional<Task> task = this.taskRepository.findById(id);

        return task;
    }

    @GetMapping("/completed/{taskDone}")
    public List<Task> getByTaskDone(@PathVariable("taskDone") boolean taskDone) {
        List<Task> tasks = this.taskRepository.findByTaskDone(taskDone);

        return tasks;
    }
}