package com.eslam.taskManger.dao;

import com.eslam.taskManger.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//@RepositoryRestResource(path = "tasks")
public interface TaskRepository extends JpaRepository<Task,Integer> {
    @Query(value = "SELECT * FROM tasks WHERE tasks.user_id = ?1", nativeQuery = true)
    List<Task> findUserTasks(long user_id);
}
