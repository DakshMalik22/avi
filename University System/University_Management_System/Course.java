package University_Management_System;

import java.util.Objects;

// Represents a course in the university
class Course {
    private int courseCode; // Unique code identifying the course
    private String courseName; // Name of the course
    private int credits; // Number of credits associated with the course

    // Constructor to initialize a Course object
    public Course(int courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }

    // Getter method to retrieve the course code
    public int getCourseCode() {
        return courseCode;
    }

    // Getter method to retrieve the course name
    public String getCourseName() {
        return courseName;
    }

    // Getter method to retrieve the number of credits
    public int getCredits() {
        return credits;
    }

    // Override equals method to compare two Course objects
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Course course = (Course) obj;
        return courseCode == course.courseCode && courseName.equals(course.courseName) && credits == course.credits;
    }

    // Override hashCode method to generate a hash code for Course objects
    @Override
    public int hashCode() {
        return Objects.hash(courseCode, courseName, credits);
    }
}
