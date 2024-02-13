package University_Management_System;

import java.util.ArrayList;

// Represents a Faculty member in the university
class Faculty extends Person {
    private int employeeId; // Employee ID of the faculty
    private String department; // Department of the faculty

    ArrayList<String> subjects = new ArrayList<>(); // List of subjects taught by the faculty

    // Constructor to initialize a Faculty object
    public Faculty(int id, String name, int age, int employeeId, String department) {
        super(id, name, age);
        this.employeeId = employeeId;
        this.department = department;
    }

    // Method to simulate teaching a course
    public void teachCourse(Course course) {
        // Check if the course is null
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }

        // Check if the course is available in the university
        if (!University.isCourseAvailable(course)) {
            throw new IllegalArgumentException("Course not available in the university");
        }

        // Display a message indicating that the faculty is teaching the course
        System.out.println(getName() + " is teaching " + course.getCourseName());
    }

    // Method to display the details of the faculty
    @Override
    public void display() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println(" Department: " + department);
    }
}
