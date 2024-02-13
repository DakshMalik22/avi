package University_Management_System;

import java.util.*;

// Student class, extending Person
class Student extends Person {
    private int studentId; // Unique student ID
    private Map<Student, List<Course>> enrolledCourses; // Map to store enrolled courses for each student

    // Constructor to initialize Student object
    public Student(int id, String name, int age, int studentId) {
        super(id, name, age); // Call superclass constructor
        this.studentId = studentId; // Initialize student ID
        this.enrolledCourses = new HashMap<>(); // Initialize map to store enrolled courses
    }

    // Getter method for student ID
    public int getStudentId() {
        return studentId;
    }

    // Method to display student information and enrolled courses
    @Override
    public void display() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Courses Enrolled:");
        List<Course> courses = enrolledCourses.getOrDefault(this, new ArrayList<>());
        for (Course course : courses) {
            System.out.println("Course Name: " + course.getCourseName());
        }
    }

    // Uncommented equals() method for object comparison
    // Uncommented hashCode() method for object hashing
}
