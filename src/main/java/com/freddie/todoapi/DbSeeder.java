package com.freddie.todoapi;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder implements CommandLineRunner {
    private TaskRepository taskRepository;

    public DbSeeder(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Task t1 = new Task("Go food shopping", false, "null", "user");
        Task t2 = new Task("Feed the dog", false, "null", "user");
        Task t3 = new Task("Workout", true, "null", "user");
        Task t4 = new Task("Wash the dishes", false, "null", "user");
        Task t5 = new Task("Do homework", true, "null", "user");
        Task t6 = new Task("Finish my app", false, "null", "user");
        Task t7 = new Task("Read a book", false, "null", "user");

        this.taskRepository.deleteAll();

        List<Task> tasks = Arrays.asList(t1, t2, t3, t4, t5, t6, t7);
        this.taskRepository.saveAll(tasks);

        System.out.println("*************************");

        List<Task> taskList = taskRepository.findAll();

        for (Task t : taskList) {
            System.out.println(t.toString());
        }
    }
}
