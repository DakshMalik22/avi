package March6;

import java.util.Scanner;

class StallPlacementException extends Exception {
    public StallPlacementException(String message) {
        super(message);
    }
}

public class AggressiveCows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of stalls: ");
        int numberOfStalls = scanner.nextInt(); // Read the number of stalls from user input
        int[] stallPositions = {6, 7, 9, 11, 13, 15}; // Array representing positions of stalls

        try {
            System.out.println(findMaximumMinimumDistance(stallPositions, numberOfStalls, 3)); // Call the findMaximumMinimumDistance method with the number of cows and print the result
        } catch (StallPlacementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to check if it's possible to place 'c' cows with minimum distance 'x' between them
    public static boolean isPlacementPossible(int[] positions, int minDistance, int cows) throws StallPlacementException {
        if (cows <= 0) {
            throw new StallPlacementException("Number of cows should be a positive integer.");
        }
        int numberOfStalls = positions.length; // Length of array positions
        int cowCount = 1; // Initialize count of cows placed with the first stall
        int distance = positions[0]; // Initialize distance 'distance' with the first stall position
        for (int index = 1; index < numberOfStalls; index++) {
            if (positions[index] - distance >= minDistance) { // If the distance between current stall and previous stall is greater than or equal to 'minDistance'
                distance = positions[index]; // Update 'distance' to current stall position
                cowCount++; // Increment count of cows placed
            } else {
                continue; // Continue to next iteration if distance is less than 'minDistance'
            }
        }
        if (cowCount >= cows) { // If number of cows placed is greater than or equal to required number of cows 'c'
            return true;
        } else {
            throw new StallPlacementException("Not enough space to place all the cows with the given minimum distance.");
        }
    }

    // Method to find maximum minimum distance such that 'k' cows can be placed
    public static int findMaximumMinimumDistance(int[] positions, int numberOfStalls, int cows) throws StallPlacementException {
        if (numberOfStalls < cows) {
            throw new StallPlacementException("Number of stalls should be greater than or equal to the number of cows.");
        }
        long answer = -1; // Initialize answer with -1
        int maxPosition = 0; // Initialize maximum stall position with 0
        for (int index = 0; index < numberOfStalls; index++) {
            maxPosition = Math.max(maxPosition, positions[index]); // Find maximum stall position
        }

        for (long minDistance = 1; minDistance <= maxPosition; minDistance++) { // Iterate from 1 to maximum stall position
            if (isPlacementPossible(positions, (int) minDistance, cows)) { // Check if it's possible to place 'cows' with minimum distance 'minDistance'
                answer = minDistance; // Update answer with current minimum distance
            } else {
                break; // Break the loop if it's not possible to place 'cows' with minimum distance 'minDistance'
            }
        }
        return (int) answer; // Return the maximum minimum distance
    }
}
