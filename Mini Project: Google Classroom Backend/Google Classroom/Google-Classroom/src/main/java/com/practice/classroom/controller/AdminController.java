package com.practice.classroom.controller;


import com.practice.classroom.dto.TaskDto;
import com.practice.classroom.dto.UserTaskDto;
import com.practice.classroom.entity.Course;
import com.practice.classroom.entity.Task;
import com.practice.classroom.service.CourseService;
import com.practice.classroom.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

   @Autowired
   private CourseService courseService;
    @Autowired
    private TaskService taskService;

    @PostMapping("{id}/create/task")
    public ResponseEntity<Void>addTask(@PathVariable Long id, @RequestBody Task task)
    {
        Course course = courseService.getCourseById(id);
        if(course==null){
            return ResponseEntity.notFound().build();
        }
        taskService.createTasksForCourse(task, id);
        return ResponseEntity.ok().build();
    }

   @PostMapping("/create/courses")
    public ResponseEntity<Course> addCourse(@RequestBody Course course)
   {
       return ResponseEntity.ok(courseService.addCourse(course));
   }

    @GetMapping("tasks/assigned/{userId}")
    public ResponseEntity<List<TaskDto>> getTasksByUserId(@PathVariable Long userId) {
        List<TaskDto> tasks = taskService.getTasksByUserId(userId);
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable Long id,@RequestBody TaskDto taskDto)
    {
        return  ResponseEntity.ok(taskService.updateTask(id,taskDto));
    }


    @GetMapping("/task/status/{userId}")
    public ResponseEntity<List<UserTaskDto>> getTasksForTaskIdAndStatus(@PathVariable Long userId,
                                                                        @RequestParam("status") String status){
        try {
            List<UserTaskDto> tasks = taskService.getTasksForUserIdAndStatus(userId, status);
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonList(new UserTaskDto("error", e.getMessage(), "")));
        }
    }


}
