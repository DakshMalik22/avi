package com.practice.classroom.service;

import com.practice.classroom.entity.Course;
import com.practice.classroom.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    public CourseRepo courseRepo;
    public Course addCourse(Course course) {
        return courseRepo.save(course);
    }

    public Course getCourseById(Long courseId)
    {
        return courseRepo.findById(courseId).orElse(null);
    }
}
