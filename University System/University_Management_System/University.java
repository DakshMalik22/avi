package University_Management_System;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class University {
    // List of students enrolled in the university
    private List<Student> students;
    // List of faculty members in the university
    public List<Faculty> faculties;

    // List of available courses offered by the university (shared among all instances)
    public static List<Course> courses;

    // Static block to initialize the courses list
    static {
        courses = new ArrayList<>();
    }

    // A map to store arbitrary key-value pairs
    HashMap<String, String> map1 = new HashMap<>();

    // Another map to store course details like course name and its corresponding course code and credits
    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    // Constructor to initialize lists
    public University() {
        this.students = new ArrayList<>();
        this.faculties = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    // Method to add a student to the university
    public void addStudent(Student student) {
        students.add(student);
    }

    // Static method to check if a course is available (exists in the courses list)
    public static boolean isCourseAvailable(Course course) {
        return courses.contains(course);
    }

    // Method to check if a student is available (enrolled) in the university
    public boolean isStudentAvailable(Student student) {
        return students.contains(student);
    }

    // Method to add a faculty member to the university
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    // Method to check if a faculty member is available (working) in the university
    public boolean isFacultyAvailable(Faculty faculty) {
        return faculties.contains(faculty);
    }

    // Method to remove a student from the university
    public void removeStudent(Student student) {
        students.remove(student);
    }

    // Method to remove a faculty member from the university
    public void removeFaculty(Faculty faculty) {
        faculties.remove(faculty);
    }

    // Method to add a course to the university
    public void addCourse(Course course) {
        // Create an inner list to store course code and credits
        ArrayList<Integer> innerList = new ArrayList<>();
        innerList.add(course.getCourseCode());
        innerList.add(course.getCredits());

        // Map the course name to its corresponding details (course code and credits)
        map.put(course.getCourseName(), innerList);

        // Add the course to the courses list
        courses.add(course);
    }

    // Method to remove a course from the university
    public void removeCourse(Course course) {
        courses.remove(course);
    }

    // Method to display details of the university including students, faculty, and courses
    public void displayUniversityDetails() {
        System.out.println("Students:");
        for (Student student : students) {
            student.display();
        }

        System.out.println("\nFaculty:");
        for (Faculty faculty : faculties) {
            faculty.display();
        }

        System.out.println("\nCourses:");
        for (Course course : courses) {
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Course Name: " + course.getCourseName());
            System.out.println("Credits: " + course.getCredits());
            System.out.println();
        }
    }
}
