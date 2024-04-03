package classroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int taskIdCount = 0;
        final String adminLoginFilePath = "C:\\Users\\ASUS\\Downloads\\weekly-Assignment6\\weekly-Assignment6\\out\\production\\Weekly-Assignment6\\database\\adminLoginFile.csv";
        final String studentLoginFilePath = "C:\\Users\\ASUS\\Downloads\\weekly-Assignment6\\weekly-Assignment6\\out\\production\\Weekly-Assignment6\\database\\studentLoginFile.csv";
        List<User> studentList = new ArrayList<>();
        List<Course> coursesList = new ArrayList<>();
        User student = null;
        User admin = null;

        do {
            System.out.println("Select your role:");
            System.out.println("1. Student.");
            System.out.println("2. Admin.");
            System.out.println("0. Exit.");

            char roleChoice = scanner.next().charAt(0);

            switch (roleChoice) {
                case '1':
                    do {
                        System.out.println("\nStudent Menu:");
                        System.out.println("1. Login");
                        System.out.println("2. Join a course");
                        System.out.println("3. Display all tasks");
                        System.out.println("4. Submit a task");
                        System.out.println("0. Logout");

                        char studentChoice = scanner.next().charAt(0);
                        switch (studentChoice) {
                            case '1':
                                if (student == null) {
                                    String studentEmail;
                                    System.out.println("Enter your email: ");
                                    while (true) {
                                        studentEmail = scanner.next();
                                        if (InputValidator.validateEmail(studentEmail)) {
                                            break;
                                        }
                                        System.out.println("Please enter a valid email:");
                                    }
                                    System.out.println("Enter your password:");
                                    String password = scanner.next();
                                    student = LoginManager.login(studentEmail, password, studentLoginFilePath);
                                } else
                                    System.out.println("Already logged in. Please logout first.");
                                break;
                            case '2':
                                if (student == null) {
                                    System.out.println("Please login first.");
                                    break;
                                }
                                System.out.println("Choose a course to join:");
                                System.out.println("1. Java Course");
                                System.out.println("2. Python Course");
                                System.out.println("3. MERN Course");
                                int courseChoice = scanner.nextInt();
                                Course courseToJoin = null;
                                switch (courseChoice) {
                                    case 1:
                                        courseToJoin = new JavaCourse("Java Course");
                                        break;
                                    case 2:
                                        courseToJoin = new PythonCourse("Python Course");
                                        break;
                                    case 3:
                                        courseToJoin = new MernCourse("MERN Course");
                                        break;
                                    default:
                                        System.out.println("Invalid input");
                                }
                                CourseManager.joinCourse(coursesList, student, studentList, courseToJoin);
                                break;
                            case '3':
                                if (student == null) {
                                    System.out.println("Please login first.");
                                    break;
                                }
                                TaskManager.displayAllTasksOfStudent(student, studentList);
                                break;
                            case '4':
                                if (student == null) {
                                    System.out.println("Please login first.");
                                    break;
                                }
                                if (TaskManager.displayAllTasksOfStudent(student, studentList)) {
                                    System.out.println("Enter the ID of the task to submit:");
                                    int submitTaskId = scanner.nextInt();
                                    TaskManager.submitTask(student, submitTaskId, studentList);
                                }
                                break;
                            case '0':
                                student = null;
                                break;
                            default:
                                System.out.println("Invalid choice");
                        }
                    } while (student != null);
                    break;
                case '2':
                    do {
                        System.out.println("\nAdmin Menu:");
                        System.out.println("1. Login");
                        System.out.println("2. Create a course");
                        System.out.println("3. Add a task");
                        System.out.println("0. Logout");

                        char adminChoice = scanner.next().charAt(0);

                        switch (adminChoice) {
                            case '1':
                                if (admin == null) {
                                    String adminEmail;
                                    System.out.println("Enter your email: ");
                                    while (true) {
                                        adminEmail = scanner.next();
                                        if (InputValidator.validateEmail(adminEmail)) {
                                            break;
                                        }
                                        System.out.println("Please enter a valid email:");
                                    }
                                    System.out.println("Enter your password:");
                                    String password = scanner.next();
                                    admin = LoginManager.login(adminEmail, password, adminLoginFilePath);
                                } else
                                    System.out.println("Already logged in. Please logout first.");
                                break;
                            case '2':
                                if (admin == null) {
                                    System.out.println("Please login first.");
                                    break;
                                }
                                System.out.println("Choose a course to create:");
                                System.out.println("1. Java Course");
                                System.out.println("2. Python Course");
                                System.out.println("3. MERN Course");
                                int courseChoice = scanner.nextInt();
                                switch (courseChoice) {
                                    case 1:
                                        CourseManager.createCourse(coursesList, new JavaCourse("Java Course"));
                                        break;
                                    case 2:
                                        CourseManager.createCourse(coursesList, new PythonCourse("Python Course"));
                                        break;
                                    case 3:
                                        CourseManager.createCourse(coursesList, new MernCourse("MERN Course"));
                                        break;
                                    default:
                                        System.out.println("Invalid input");
                                }
                                break;
                            case '3':
                                if (admin == null) {
                                    System.out.println("Please login first.");
                                    break;
                                }
                                Task newTask = TaskManager.createTask(++taskIdCount);
                                TaskManager.addTask(newTask, studentList, coursesList);
                                break;
                            case '0':
                                admin = null;
                                break;
                            default:
                                System.out.println("Invalid choice");
                        }

                    } while (admin != null);
                    break;
                case '0':
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (true);
    }
}
