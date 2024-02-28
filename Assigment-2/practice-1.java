package Assigment_2;

import java.util.Comparator;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

// Interface defining basic operations for an employee
interface Employee extends Serializable {
    // Method to add an employee
    void addEmployee(int id, String name, String position, double salary) throws EmployeeManagementException;
    
    // Method to remove an employee
    void removeEmployee(int id) throws EmployeeManagementException;
    
    // Method to display information of a specific employee
    void displayEmployeeInfo(int id) throws EmployeeManagementException;
    
    // Method to display information of all employees
    void displayAllEmployees();
    
    // Method to calculate the total salary of all employees
    double calculateTotalSalary();
    
    // Method to sort employees by salary
    void sortEmployeesBySalary();
    
    // Method to search for employees based on a keyword
    List<EmployeeInfo> searchEmployees(String keyword);
    
    // Method to update information of an employee
    void updateEmployeeInfo(int id, String name, String position, double salary) throws EmployeeManagementException;
}

// Class representing information of an employee
class EmployeeInfo implements Serializable {
    private int id;
    private String name;
    private String position;
    private double salary;

    public EmployeeInfo(int id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
    }
}

// Class implementing the Employee interface for full-time employees
class FullTimeEmployee implements Employee {
    private List<EmployeeInfo> employees;

    public FullTimeEmployee() {
        this.employees = new ArrayList<>();
    }

    @Override
    public void addEmployee(int id, String name, String position, double salary) throws EmployeeManagementException {
        // Checking if employee with the same ID already exists
        for (EmployeeInfo employee : employees) {
            if (employee.getId() == id) {
                throw new EmployeeManagementException("Employee ID already exists!");
            }
        }
        // Add the new employee
        employees.add(new EmployeeInfo(id, name, position, salary));
    }

    @Override
    public void removeEmployee(int id) throws EmployeeManagementException {
        // Removeing employee with the given ID
        boolean removed = employees.removeIf(employee -> employee.getId() == id);
        if (!removed) {
            throw new EmployeeManagementException("Employee not found!");
        }
    }

    @Override
    public void displayEmployeeInfo(int id) throws EmployeeManagementException {
        // Displaying information of the employee with the given ID
        for (EmployeeInfo employee : employees) {
            if (employee.getId() == id) {
                System.out.println(employee);
                return;
            }
        }
        throw new EmployeeManagementException("Employee not found!");
    }

    @Override
    public void displayAllEmployees() {
        // Displaying information of all employees
        employees.forEach(System.out::println);
    }

    @Override
    public double calculateTotalSalary() {
        // Calculating the total salary of all employees
        return employees.stream().mapToDouble(EmployeeInfo::getSalary).sum();
    }

    @Override
    public void sortEmployeesBySalary() {
        // Sorting employees by salary
        employees.sort(Comparator.comparingDouble(EmployeeInfo::getSalary));
    }

    @Override
    public List<EmployeeInfo> searchEmployees(String keyword) {
        // Searching for employees based on a keyword
        List<EmployeeInfo> result = new ArrayList<>();
        for (EmployeeInfo employee : employees) {
            if (employee.getName().contains(keyword) || employee.getPosition().contains(keyword) ||
                    String.valueOf(employee.getSalary()).contains(keyword)) {
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public void updateEmployeeInfo(int id, String name, String position, double salary) throws EmployeeManagementException {
        // Updating information of the employee with the given ID
        for (EmployeeInfo employee : employees) {
            if (employee.getId() == id) {
                employee = new EmployeeInfo(id, name, position, salary);
                return;
            }
        }
        throw new EmployeeManagementException("Employee not found!");
    }
}

// Custom exception class for employee management related exceptions
class EmployeeManagementException extends Exception {
    public EmployeeManagementException(String message) {
        super(message);
    }
}

// Main class for the employee management system
public class practice {
    public static void main(String[] args) {
       
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee();
        
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
       
        while (choice != 7) {
            System.out.println("\nEmployee Management System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Display Employee Information");
            System.out.println("4. Display All Employees");
            System.out.println("5. Calculate Total Salary");
            System.out.println("6. Sort Employees by Salary");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        // Add Employee
                        try {
                            System.out.print("Enter Employee ID: ");
                            int id = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            System.out.print("Enter Name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter Position: ");
                            String position = scanner.nextLine();
                            System.out.print("Enter Salary: ");
                            double salary = scanner.nextDouble();
                            fullTimeEmployee.addEmployee(id, name, position, salary);
                            System.out.println("Employee added successfully!");
                        } catch (EmployeeManagementException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 2:
                        // Remove Employee
                        System.out.print("Enter Employee ID to remove: ");
                        int removeId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        try {
                            fullTimeEmployee.removeEmployee(removeId);
                            System.out.println("Employee removed successfully!");
                        } catch (EmployeeManagementException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 3:
                        // Display Employee Information
                        System.out.print("Enter Employee ID: ");
                        int displayId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        try {
                            fullTimeEmployee.displayEmployeeInfo(displayId);
                        } catch (EmployeeManagementException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 4:
                        // Display All Employees
                        fullTimeEmployee.displayAllEmployees();
                        break;

                    case 5:
                        // Calculate Total Salary
                        System.out.println("Total Salary: " + fullTimeEmployee.calculateTotalSalary());
                        break;

                    case 6:
                        // Sort Employees by Salary
                        fullTimeEmployee.sortEmployeesBySalary();
                        fullTimeEmployee.displayAllEmployees();
                        break;

                    case 7:
                        // Exit
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                }
            } catch (java.util.InputMismatchException ex) {
                System.out.println("Invalid input type. Please enter a valid integer choice.");
                scanner.nextLine(); // Consume newline
            }
        }
        // Close the Scanner object
        scanner.close();
    }
}
