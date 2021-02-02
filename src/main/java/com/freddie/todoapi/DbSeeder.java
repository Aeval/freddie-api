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

        Task t1 = new Task("Go food shopping", false, "2021-01-09", "ankouaeval@gmail.com");
        Task t2 = new Task("Feed the dog", false, "2021-01-09", "ankouaeval@gmail.com");
        Task t3 = new Task("Workout", true, "2021-01-09", "ankouaeval@gmail.com");
        Task t4 = new Task("Wash the dishes", false, "2021-01-09", "ankouaeval@gmail.com");
        Task t5 = new Task("Do homework", true, "2021-01-09", "ankouaeval@gmail.com");
        Task t6 = new Task("Finish my app", false, "2021-01-09", "ankouaeval@gmail.com");
        Task t7 = new Task("Read a book", false, "2021-01-09", "ankouaeval@gmail.com");
        Task t8 = new Task("Write a novel", true, "2021-01-09", "ankouaeval@gmail.com");
        Task t9 = new Task("Figure out Spring Boot", true, "2021-01-09", "ankouaeval@gmail.com");
        Task t10 = new Task("Build a new computer", false, "2021-01-09", "ankouaeval@gmail.com");
        Task t11 = new Task("Go outside", false, "2021-01-09", "ankouaeval@gmail.com");
        Task t12 = new Task("Add a new task", true, "2021-01-09", "ankouaeval@gmail.com");

        this.taskRepository.deleteAll();

        List<Task> tasks = Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12);
        this.taskRepository.saveAll(tasks);

        System.out.println("*************************");

        List<Task> taskList = taskRepository.findAll();

        for (Task t : taskList) {
            System.out.println(t.toString());
        }
    }
}
