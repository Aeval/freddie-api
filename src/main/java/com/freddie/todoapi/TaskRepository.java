package com.freddie.todoapi;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
    Optional<Task> findById(String id);

    List<Task> findByTaskName(boolean taskName);

    List<Task> findByTaskDone(boolean taskDone);

    List<Task> findAllByUsername(String username);
}
