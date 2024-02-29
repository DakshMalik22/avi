package src;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// Class for comparing CSV files
public class CsvFileComparator {
    // File name of the CSV
    public String fileName;

    // Constructor to initialize the file name
    public CsvFileComparator(String fileName) {
        this.fileName = fileName;
    }

    // Method to compare two CSV files
    public static void ComparingCsv(CsvFileComparator actual, CsvFileComparator expected) {
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        // Format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss-SSS");
        String formattedDateTime = now.format(formatter);
        // Flag to track if differences are found
        boolean differencesFound = false;
        // Scanner object for reading input
        Scanner scanner = new Scanner(System.in);

        try (BufferedReader  actualFileReader = new BufferedReader(new FileReader(actual.fileName));
             BufferedReader expectedFileReader = new BufferedReader(new FileReader(expected.fileName))) {

            String currentLine1;
            String currentLine2;
            int row = 0;

            // Read the header line of the first file
            String[] header =  actualFileReader.readLine().split(",");
            // Prompt the user to specify a column to skip
            System.out.println("Enter the column to skip: ");
            String skip = scanner.nextLine();
            int skipcol = -1;
            // Find the index of the column to skip
            for (int i = 0; i < header.length; i++) {
                if (header[i].equals(skip)) {
                    skipcol = i;
                }
            }
            // Read the header line of the second file
            expectedFileReader.readLine();

            // Iterate through each line of both files
            while ((currentLine1 =  actualFileReader.readLine()) != null && (currentLine2 = expectedFileReader.readLine()) != null) {
                String[] details1 = currentLine1.split(",");
                String[] details2 = currentLine2.split(",");

                // Compare values in each column
                for (int column = 0; column < details1.length; column++) {
                    // If values in the same column are not equal
                    if (!details1[column].equals(details2[column])) {
                        differencesFound = true; // Set flag to true if differences are found
                        break;
                    }
                }
                if (differencesFound) {
                    break; // Exit loop if differences are found
                }
                row++;
            }

            // Create a result file if differences are found
            if (differencesFound) {
                try (BufferedWriter fw = new BufferedWriter(new FileWriter(formattedDateTime + "result100.csv"))) {
                    fw.write("Cell,Actual File,Expected File\n");

                    // Reset file pointers to read from the beginning again
                    BufferedReader br4 = new BufferedReader(new FileReader(actual.fileName));
                    BufferedReader br5 = new BufferedReader(new FileReader(expected.fileName));
                    br4.readLine();
                    br5.readLine();

                    // Skip header line
                    while ((currentLine1 = br4.readLine()) != null && (currentLine2 = br5.readLine()) != null) {
                        String[] details1 = currentLine1.split(",");
                        String[] details2 = currentLine2.split(",");
                        for (int column = 0; column < details1.length; column++) {
                            // If values in the same column are not equal and it's not the skipped column
                            if (!details1[column].equals(details2[column]) && column != skipcol) {
                                fw.write("Row " + row + " Col " + column + " " + header[column] + ":," + details1[column] + "," + details2[column] + "\n");
                            }
                        }
                        row++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
