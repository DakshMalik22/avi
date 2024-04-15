package com.practice.classroom.service;

import com.practice.classroom.dto.TaskDto;
import com.practice.classroom.dto.UserTaskDto;
import com.practice.classroom.entity.Course;
import com.practice.classroom.entity.Task;
import com.practice.classroom.entity.User;
import com.practice.classroom.entity.UserTask;
import com.practice.classroom.repository.CourseRepo;
import com.practice.classroom.repository.TaskRepo;
import com.practice.classroom.repository.UserRepo;
import com.practice.classroom.repository.UserTaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CourseRepo courseRepository;

    @Autowired
    private UserTaskRepo userTaskRepo;

    public Task addTask(Task task) {
        return taskRepo.save(task);
    }


    public void createTasksForCourse(Task task, Long courseId) {
        Course course = courseRepository.findById(courseId).get();

        // Retrieve all users enrolled in the course
        List<User> enrolledUsers = course.getUsers();

        // Create the task for each enrolled user
        for (User user : enrolledUsers) {
            UserTask userTask = new UserTask();
            userTask.setTask(task);
            userTask.setUser(user);
            userTask.setStatus("pending");

            userTaskRepo.save(userTask);
        }
        taskRepo.save(task);
    }

    public List<TaskDto> getTasksByUserId(Long userId) {
        User user = userRepo.findById(userId).get();

        Course course = user.getCourse();

          List<Task> tasks =  taskRepo.findTasksByCourseId(course.getId());
          return tasks
                  .stream()
                  .map(emp->new TaskDto(
                          emp.getId(),
                          emp.getDescription(),
                          emp.getSubmissionDate(),
                          emp.getCourse().getName()
                  )).collect(Collectors.toList());
    }


    public TaskDto updateTask(Long id, TaskDto taskDto) {
        Task  task = taskRepo.findById(id).get();

        if(Objects.nonNull(taskDto.getDescription()) &&  !"".equalsIgnoreCase(taskDto.getDescription()))
        {
            task.setDescription(taskDto.getDescription());
        }

        if(Objects.nonNull(taskDto.getSubmissionDate()) && !"".equalsIgnoreCase(taskDto.getSubmissionDate()))
        {
            task.setSubmissionDate(taskDto.getSubmissionDate());
        }

        taskRepo.save(task);
        return taskDto;
    }

    public List<UserTaskDto> getTasksForUserIdAndStatus(Long userId, String status) {
         List<UserTask> userTasks = userTaskRepo.getTasksForUserIdAndStatus(userId,status);

         return userTasks.stream()
                 .map(emp->new UserTaskDto(
                         emp.getStatus(),
                         emp.getUser().getName(),
                         emp.getTask().getDescription()
                 )).collect(Collectors.toList());
    }
}
