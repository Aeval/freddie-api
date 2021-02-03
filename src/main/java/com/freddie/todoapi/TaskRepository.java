package com.freddie.todoapi;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
    Optional<Task> findById(String id);

    List<Task> findByTaskName(boolean taskName);

    List<Task> findByTaskDone(boolean taskDone);

    List<Task> findByUsername(String username);

    @Query("{'username': ?#{[0]}, 'taskName': { $regex: ?#{[1]}, $options: 'i' }}")
    List<Task> findAllByUsernameandContainsTaskName(String username, String taskName, Pageable pageable);

    Page<Task> findByTaskNameContaining(String taskName, Pageable pageable);
}
