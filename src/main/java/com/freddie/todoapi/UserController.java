package com.freddie.todoapi;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
        String taskName = params.get("taskName").get(0);
        String sortDirection = params.get("sortDirection").get(0);
        System.out.println("name: " + taskName);
        System.out.println("Getting Tasks for: " + principal.getName().toString());
        // Sort.by(Direction.ASC, "dueDate") : Sort.by(Direction.DESC, "dueDate");

        final String username = principal.getName();

        List<Task> list = this.taskRepository.findByUsername(username);

        Pageable pageable = PageRequest.of(pageIndex, (pageSize == 1) ? list.size() : pageSize,
                Sort.by(sortDirection.equals("asc") ? Direction.ASC : Direction.DESC, "dueDate"));

        System.out.println(pageable.toString());

        List<Task> tasks = this.taskRepository.findAllByUsernameandContainsTaskName(username, taskName, pageable);
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
