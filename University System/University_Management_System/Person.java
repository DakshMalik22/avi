package University_Management_System;

// Abstract class representing a person in the university
abstract class Person {
    private int id; // Unique identifier for the person
    private String name; // Name of the person
    private int age; // Age of the person

    // Constructor to initialize a person object with ID, name, and age
    public Person(int id, String name, int age) {
        this.age = age; // Initialize age
        this.id = id; // Initialize ID
        this.name = name; // Initialize name
    }

    // Getter method for age
    public int getAge() {
        return age;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Getter method for ID
    public int getId() {
        return id;
    }

    // Abstract method to be implemented by subclasses to display person information
    public abstract void display();
}
