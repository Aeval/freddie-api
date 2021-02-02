package com.freddie.todoapi;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private TaskRepository taskRepository;

    public UserController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/user/tasks")
    public List<Task> tasks(Principal principal, @RequestParam MultiValueMap<String, String> params) {

        int pageIndex = Integer.parseInt(params.get("pageIndex").get(0));
        int pageSize = Integer.parseInt(params.get("pageSize").get(0));
        System.out.println("Index: " + pageIndex + ", Size: " + pageSize);
        System.out.println("Getting Tasks for: " + principal.getName().toString());

        final String username = principal.getName();

        List<Task> list = this.taskRepository.findByUsername(username);

        Pageable pageable = PageRequest.of(pageIndex, (pageSize == 1) ? list.size() : pageSize);

        System.out.println(pageable.toString());

        List<Task> tasks = this.taskRepository.findAllByUsername(username, pageable);
        System.out.println(tasks);
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
