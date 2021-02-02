package com.freddie.todoapi;

import java.security.Principal;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private TaskRepository taskRepository;

    public UserController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/user/tasks")
    public List<Task> tasks(Principal principal) {
        System.out.println("Getting Tasks for: " + principal.getName().toString());
        final String username = principal.getName();
        List<Task> tasks = this.taskRepository.findAllByUsername(username);
        if (tasks.isEmpty()) {
            return List.of();
        } else {
            return tasks;
        }

    }

    @GetMapping("/user")
    public OidcUser user(@AuthenticationPrincipal OidcUser user) {
        return user;
    }

}
