// package com.freddie.todoapi;

// import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
// import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.stereotype.Component;

// @Component
// @RepositoryEventHandler(Task.class)
// public class AddUserToTask {

// @HandleBeforeCreate
// public void handleTaskBeforeCreate(Task task) {
// System.out.println("ARE WE EVEN GETTING HERE?!");
// final String username =
// SecurityContextHolder.getContext().getAuthentication().getName();

// task.setUsername(username);
// }
// }
