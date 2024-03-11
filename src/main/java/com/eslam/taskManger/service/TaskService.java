package com.eslam.taskManger.service;

import com.eslam.taskManger.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TaskService {

    List<Task> findAll();
    List<Task> findUserTasks(long user_id);
    Task findById(int theId);

    void save(Task theEmployee);

    void deleteById(int theId);
}
