package file_handling_system;

import java.io.Serializable;

public class Student implements Serializable {
    private int rollNo;
    private String  name;

    private double grade;
    private int id;

    public Student(int id,String name,int rollNo,double grade)
    {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public int getRollNo() {
        return rollNo;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rollNumber =" + rollNo +
                ", grade=" + grade +
                '}';
    }
}
