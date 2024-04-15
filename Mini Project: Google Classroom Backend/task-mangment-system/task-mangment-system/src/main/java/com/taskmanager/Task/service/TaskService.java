package com.taskmanager.Task.service;


import com.taskmanager.Task.entity.UserEntity;
import com.taskmanager.Task.repository.TaskRepo;
import com.taskmanager.Task.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.taskmanager.Task.entity.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TaskService {

    @Autowired
    public TaskRepo taskRepo;

    @Autowired
    public UserRepo userRepo;
    public ResponseEntity<TaskEntity> addTask(TaskEntity task) {
        Integer userId = task.getUser().getUserId();
        UserEntity user = userRepo.findById(userId).orElse(null);
        if (user == null) {
            // Handle case where user doesn't exist
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        task.setUser(user);
        return new ResponseEntity<>(taskRepo.save(task), HttpStatus.CREATED);
    }

    public ResponseEntity<List<TaskEntity>> fetchAllTasksByUserId(Integer id) {
        List<TaskEntity> store=  taskRepo.findByUserUserId(id);
        return ResponseEntity.ok(store);
    }

    public ResponseEntity<TaskEntity> updateTask(Integer id, TaskEntity newTask) {
       TaskEntity task = taskRepo.findById(id).get();
       if(Objects.nonNull(newTask.getDescription()) &&  !"".equalsIgnoreCase(newTask.getDescription()))
       {
           task.setDescription(newTask.getDescription());
       }
       if(Objects.nonNull(newTask.getStatus()) && !"".equalsIgnoreCase(newTask.getStatus())){
           task.setStatus(newTask.getStatus());
       }
       if(Objects.nonNull(newTask.getPriority()) && !"".equalsIgnoreCase(newTask.getPriority())){
           task.setStatus(newTask.getPriority());
       }
       if(Objects.nonNull(newTask.getDueDate()) && !"".equalsIgnoreCase(newTask.getDueDate()))
       {
           task.setStatus(newTask.getDueDate());
       }

       return ResponseEntity.ok(taskRepo.save(task));
    }

    public ResponseEntity<TaskEntity> deleteTask(Integer id) {

        taskRepo.deleteById(id);
        return ResponseEntity.accepted().build();

    }
}
