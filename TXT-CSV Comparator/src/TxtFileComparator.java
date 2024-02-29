package src;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// Class for comparing text files
public class TxtFileComparator {
    // File name of the text file
    public String fileName;

    // Constructor to initialize the file name
    public TxtFileComparator(String fileName) {
        this.fileName = fileName;
    }

    // Method to compare two text files
    public static void ComparingTxt(TxtFileComparator actual, TxtFileComparator expected) {
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        // Format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss-SSS");
        String formattedDateTime = now.format(formatter);
        // Flag to track if differences are found
        boolean differencesFound = false;
        // Scanner object for reading input
        Scanner scanner = new Scanner(System.in);

        try (BufferedReader actualFileReader = new BufferedReader(new FileReader(actual.fileName));
             BufferedReader expectedFileReader = new BufferedReader(new FileReader(expected.fileName))) {

            String currentLine1;
            String currentLine2;
            int sentenceIndex = 0; // Index of the current sentence

            // Read each line from both files
            while ((currentLine1 = actualFileReader.readLine()) != null && (currentLine2 = expectedFileReader.readLine()) != null) {
                sentenceIndex++; // Increment the sentence index
                // Split lines into segments based on ". "
                String[] segments1 = currentLine1.split("\\. ");
                String[] segments2 = currentLine2.split("\\. ");

                // Determine the minimum length of segments
                int minLength = Math.min(segments1.length, segments2.length);

                // Iterate through each segment
                for (int sentence = 0; sentence < minLength; sentence++) {
                    // Increment the sentence index for each segment
                    sentenceIndex++;
                    // Split segment into words based on whitespace
                    String[] words1 = segments1[sentence].split("\\s+");
                    String[] words2 = segments2[sentence].split("\\s+");

                    // Determine the minimum length of words in the segment
                    int minWordLength = Math.min(words1.length, words2.length);

                    // Iterate through each word in the segment
                    for (int word = 0; word < minWordLength; word++) {
                        // If words in the same position are not equal
                        if (!words1[word].equals(words2[word])) {
                            // Print the difference along with the sentence index
                            System.out.println("Difference found in sentence " + sentenceIndex + ": " + words1[word] + " <> " + words2[word]);
                            differencesFound = true; // Set flag to true if differences are found
                        }
                    }
                }
            }

            // If no differences are found in the lines, indicate that files are equal
            if (!differencesFound) {
                System.out.println("Files are Equal");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
