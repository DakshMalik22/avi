package com.taskmanager.Task.controller;


import com.taskmanager.Task.entity.TaskEntity;
import com.taskmanager.Task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class TaskController{

    @Autowired
    public TaskService taskService;

    @PostMapping("add")
    public ResponseEntity<TaskEntity> addTask(@RequestBody TaskEntity task)
    {
       return taskService.addTask(task);
    }

    @GetMapping("tasks/{id}")
    public ResponseEntity<List<TaskEntity>> fetchAllTasksByUserId(@PathVariable Integer id)
    {
        return taskService.fetchAllTasksByUserId(id);
    }

    @PutMapping("update/task/{id}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable Integer id,@RequestBody TaskEntity newTask)
    {
        return taskService.updateTask(id,newTask);
    }

    @DeleteMapping("delete/task/{id}")
    public ResponseEntity<TaskEntity> deleteTask(@PathVariable Integer id)
    {
        return taskService.deleteTask(id);
    }

}
