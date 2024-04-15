package com.taskmanager.Task.repository;


import com.taskmanager.Task.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<TaskEntity,Integer> {
    List<TaskEntity> findByUserUserId(Integer userId);
}
