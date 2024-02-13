package University_Management_System;

import java.util.*;

public class system1 {
    public static void main(String[] args) {
        // Create an instance of the University
        University university = new University();

        // Create a scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Start a loop to display the main menu and handle user inputs
        while (true) {
            // Display the main menu options
            System.out.println("\nUniversity Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Faculty");
            System.out.println("3. Add Course");
            System.out.println("4. Display University Details");
            System.out.println("5. Remove Course");
            System.out.println("6. Remove Student");
            System.out.println("7. Remove Faculty");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            // Take user input for their choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Switch statement to perform actions based on user's choice
            switch (choice) {
                case 1: // If user chooses to add a student
                    // Prompt user to enter student details
                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter Student Age: ");
                    int studentAge = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Student's Course (e.g., Computer Science): ");
                    String studentCourse = scanner.nextLine();

                    // Check if the entered course exists in the University
                    if (University.map.containsKey(studentCourse)) {
                        // Create a new Course object based on the input
                        Course course1 = new Course(University.map.get(studentCourse).get(0), studentCourse, University.map.get(studentCourse).get(1));

                        // Check if the course is registered in the university
                        if (University.courses.contains(course1)) {
                            // Create a new Student object and add it to the university
                            Student student = new Student(studentId, studentName, studentAge, studentId);
                            university.addStudent(student);
                            System.out.println("Student added successfully!");
                        } else {
                            System.out.println("No such course available!!!");
                        }
                    } else {
                        System.out.println("No such course exists!!!");
                    }
                    break;

                case 2: // If user chooses to add a faculty
                    // Prompt user to enter faculty details
                    System.out.print("Enter Faculty ID: ");
                    int facultyId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Faculty Name: ");
                    String facultyName = scanner.nextLine();
                    System.out.print("Enter Faculty Age: ");
                    int facultyAge = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Faculty Employee ID: ");
                    int employeeId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Faculty Department: ");
                    String department = scanner.nextLine();

                    // Create a new Faculty object and add it to the university
                    Faculty faculty = new Faculty(facultyId, facultyName, facultyAge, employeeId, department);
                    university.addFaculty(faculty);
                    System.out.println("Faculty added successfully!");
                    break;

                case 3: // If user chooses to add a course
                    // Prompt user to enter course details
                    System.out.print("Enter Course Code: ");
                    int courseCode = scanner.nextInt();
                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.next();
                    System.out.print("Enter Course Credits: ");
                    int credits = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Create a new Course object and add it to the university
                    Course course = new Course(courseCode, courseName, credits);
                    university.addCourse(course);
                    System.out.println("Course added successfully!");
                    break;

                case 4: // If user chooses to display university details
                    // Display the details of all students, faculties, and courses in the university
                    university.displayUniversityDetails();
                    break;

                case 5: // If user chooses to remove a course
                    // Prompt user to enter course details
                    System.out.print("Enter Course Code: ");
                    int courseCode1 = scanner.nextInt();
                    System.out.print("Enter Course Name: ");
                    String courseName1 = scanner.nextLine();
                    System.out.print("Enter Course Credits: ");
                    int credits1 = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Create a new Course object to remove and check if it exists in the university
                    Course courseToRemove = new Course(courseCode1, courseName1, credits1);
                    if (University.isCourseAvailable(courseToRemove)) {
                        // If the course exists, remove it from the university
                        university.removeCourse(courseToRemove);
                        System.out.println("Course removed successfully!");
                    } else {
                        // If the course doesn't exist, display an error message
                        System.out.println("Course not available in the university!");
                    }
                    break;

                case 6: // If user chooses to remove a student
                    // Prompt user to enter student details
                    System.out.print("Enter Student ID: ");
                    int studentId1 = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Student Name: ");
                    String studentName1 = scanner.nextLine();
                    System.out.print("Enter Student Age: ");
                    int studentAge1 = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Student's Course (e.g., Computer Science): ");
                    String studentCourse1 = scanner.nextLine();

                    // Create a new Student object to remove and check if it exists in the university
                    Student student1 = new Student(studentId1, studentName1, studentAge1, studentId1);
                    if (university.isStudentAvailable(student1)) {
                        // If the student exists, remove it from the university
                        university.removeStudent(student1);
                        System.out.println("Student removed successfully!");
                    } else {
                        // If the student doesn't exist, display an error message
                        System.out.println("Student not available in the university!");
                    }
                    break;

                case 7: // If user chooses to remove a faculty
                    // Prompt user to enter faculty ID
                    System.out.print("Enter Faculty ID: ");
                    int facultyId1 = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Search for faculty by ID in the list of faculties
                    Faculty facultyToRemove = null;
                    for (Faculty faculty1: university.faculties) {
                        if (faculty1.getId() == facultyId1) {
                            facultyToRemove = faculty1;
                            break;
                        }
                    }

                    // If the faculty is found, remove it from the university
                    if (facultyToRemove != null) {
                        university.removeFaculty(facultyToRemove);
                        System.out.println("Faculty removed successfully!");
                    } else {
                        // If the faculty is not found, display an error message
                        System.out.println("Faculty not available in the university!");
                    }
                    break;

                case 8: // If user chooses to exit the system
                    System.out.println("Exiting University Management System...");
                    System.exit(0);
                    break;

                default: // If user enters an invalid choice
                    // Display an error message
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
        }
    }
}

