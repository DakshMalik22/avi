package Singleton;

// Singleton class definition
public class Singleton {
    // Private constructor to prevent instantiation from outside the class
    private Singleton() {
        // Constructor body is empty
    }

    // Static variable to hold the single instance of the class
    private static Singleton instance;

    // Method to get the instance of the Singleton class
    public static Singleton getInstance() {
        // Check if the instance is null (i.e., not instantiated yet)
        if (instance == null) {
            // Create a new instance if it doesn't exist
            instance = new Singleton();
        }

        // Return the instance
        return instance;
    }
}
