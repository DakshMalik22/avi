package com.taskmanager.Task.service;

import com.taskmanager.Task.entity.TaskEntity;
import com.taskmanager.Task.entity.UserEntity;
import com.taskmanager.Task.repository.TaskRepo;
import com.taskmanager.Task.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    public UserRepo userRepo;

    @Autowired
    public TaskRepo taskRepo;

    public ResponseEntity<UserEntity> addUser(UserEntity userEntity) {
        return ResponseEntity.ok(userRepo.save(userEntity));
    }


    public ResponseEntity<List<TaskEntity>> fetchAllTasksByUserId(Integer id) {
       List<TaskEntity> store=  taskRepo.findByUserUserId(id);
        return ResponseEntity.ok(store);
    }

    public ResponseEntity<TaskEntity> updateStatus(Integer id, TaskEntity taskEntity) {
        TaskEntity  taskEntity1 =taskRepo.findById(id).get();
        if(Objects.nonNull(taskEntity.getStatus()) && !"".equalsIgnoreCase(taskEntity.getStatus())){
            taskEntity1.setStatus(taskEntity.getStatus());
        }
        return ResponseEntity.ok(taskEntity1);
    }
}
