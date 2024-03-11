package com.eslam.taskManger.service;

import com.eslam.taskManger.dao.TaskRepository;
import com.eslam.taskManger.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findUserTasks(long user_id) {
        return taskRepository.findUserTasks(user_id);
    }

    @Override
    public Task findById(int theId) {

        Optional<Task> result = taskRepository.findById(theId);

        Task task = null;

        if (result.isPresent()) {
            task = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find task id - " + theId);
        }

        return task;
    }

    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteById(int theId) {
        taskRepository.deleteById(theId);
    }
}
