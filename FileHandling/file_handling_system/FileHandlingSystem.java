package file_handling_system;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileHandlingSystem {
    private List<Student> students;
    private String filename;

    public FileHandlingSystem(String filename) {
        this.filename = filename;
         this.students = new ArrayList<>();
    }

    public void addStudent(Student student)
    {
        students.add(student);
    }

    public void serializeToFile()
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
           oos.writeObject(students);
            System.out.println("Student records serialized to " + filename);
        } catch (IOException e) {
            System.out.println("Error serializing student records: " + e.getMessage());
        }
    }

    public void deserializeToFile()
    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
           students = (List<Student>) ois.readObject();
            System.out.println("Student records Deserialized to " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error Deserialized student records: " + e.getMessage());
        }
    }
    public void printStudentDetails(){
        for (Student student:students)
        {
            System.out.println(student);
        }
    }

    public void filterStudentsByGrade(double minGrade) {
        List<Student> filteredStudents = students.stream()
                .filter(student -> student.getGrade() >= minGrade)
                .collect(Collectors.toList());

        System.out.println("Students with grade >= " + minGrade + ":");
        for (Student student : filteredStudents) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        FileHandlingSystem fileHandlingSystem = new FileHandlingSystem("studentDatabase.txt");

        // Add some sample student records
        fileHandlingSystem.addStudent(new Student(1, "Alice", 20, 3.9));
        fileHandlingSystem.addStudent(new Student(2, "Bob", 21, 3.7));
        fileHandlingSystem.addStudent(new Student(3, "Charlie", 22, 3.5));

        // Serialize the student records to a file
        fileHandlingSystem.serializeToFile();

        // Deserialize the student records from the file
        fileHandlingSystem.deserializeToFile();

        // Print the student records
        fileHandlingSystem.printStudentDetails();

        // Filter and print students with grade >= 3.7
        fileHandlingSystem.filterStudentsByGrade(3.7);
    }

}
