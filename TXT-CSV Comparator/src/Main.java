package src;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

// Main class
public class Main {
    // Main method
    public static void main(String[] args) {
        // Creating a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        try {
            // Prompting the user to enter their choice
            System.out.print("Enter your choice: ");

            // Reading the user's choice
            int choice = scanner.nextInt();

            // Consuming the newline character after reading the integer
            scanner.nextLine();

            // Switch statement to perform actions based on user's choice
            switch (choice) {
                // If user chose option 1
                case 1:
                    System.out.println("You chose Option 1");
                    // Prompting the user to enter paths for File1 and File2
                    System.out.println("Enter The File1 path: ");
                    // Reading path for File1
                    String actualCsv = scanner.nextLine();
                    System.out.println("Enter The File2 path: ");
                    // Reading path for File2
                    String expectedCsv = scanner.nextLine();
                    // Creating CsvFileComparator objects for File1 and File2
                    CsvFileComparator actualCsvFile = new CsvFileComparator(actualCsv);
                    CsvFileComparator expectedCsvFile = new CsvFileComparator(expectedCsv);
                    // Calling the Check method to compare File1 and File2
                    CsvFileComparator.ComparingCsv(actualCsvFile, expectedCsvFile);
                    break;

                // If user chose option 2
                case 2:
                    System.out.println("You chose Option 2");
                    // Prompting the user to enter paths for File3 and File4
                    System.out.println("Enter The File1 path: ");
                    // Reading path for File3
                    String actualTxt = scanner.nextLine();
                    System.out.println("Enter The File2 path: ");
                    // Reading path for File4
                    String expectedTxt = scanner.nextLine();
                    // Creating TxtFileComparator objects for File3 and File4
                    TxtFileComparator actualTxtFile = new TxtFileComparator(actualTxt);
                    TxtFileComparator expectedTxtFile = new TxtFileComparator(expectedTxt);
                    // Calling the CheckTxt method to compare File3 and File4
                    TxtFileComparator.ComparingTxt(actualTxtFile, expectedTxtFile);
                    break;

                // If user entered an invalid choice
                default:
                    System.out.println("Invalid choice");
            }
        }catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid choice.");
        } catch (NoSuchElementException e) {
            System.out.println("Input not found. Please provide all required inputs.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }finally {
            // Close the scanner to prevent resource leak
            scanner.close();
        }
    }
}
