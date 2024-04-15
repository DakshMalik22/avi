package com.taskmanager.Task.controller;


import com.taskmanager.Task.entity.TaskEntity;
import com.taskmanager.Task.entity.UserEntity;
import com.taskmanager.Task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    public UserService userService;


    @PostMapping("add")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity userEntity){
        return  userService.addUser(userEntity);
    }

    @GetMapping("tasks/{id}")
    public ResponseEntity<List<TaskEntity>> fetchAllTasksByUserId(@PathVariable Integer id)
    {
       return userService.fetchAllTasksByUserId(id);
    }

    @PutMapping("update/status/{id}")
    public ResponseEntity<TaskEntity> updateStatus(@PathVariable Integer id,@RequestBody TaskEntity taskEntity)
    {
        return userService.updateStatus(id,taskEntity);
    }
}
