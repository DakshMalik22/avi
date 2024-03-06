package March5;

import java.util.Scanner;

public class GridLargestSum {

    // Custom exception class for handling invalid input
    static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }

    // Method to calculate the maximum sum of non-adjacent elements in the grid
    public static int maxSumNoAdjacent(int[][] grid) {
        // Check for empty grid
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        // Dynamic programming table to store maximum sum
        int[][] dp = new int[rows][cols];

        // Base cases
        dp[0][0] = grid[0][0];

        // If there are more than one column, set up base case for the second column
        if (cols > 1)
            dp[0][1] = Math.max(grid[0][0], grid[0][1]);

        // Fill the dp table
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == 0 && col < 2)
                    continue;

                // Check for adjacent elements
                int adjSum = Math.max(row > 0 ? dp[row - 1][col] : 0, col > 0 ? dp[row][col - 1] : 0);
                dp[row][col] = Math.max(adjSum, col > 1 ? dp[row][col - 2] + grid[row][col] : grid[row][col]);
            }
        }

        // Return the maximum sum from the last row
        int maxSum = 0;
        for (int col = 0; col < cols; col++) {
            maxSum = Math.max(maxSum, dp[rows - 1][col]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        try {
            // Taking input of the grid
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the number of columns in the grid:");
            int numOfColumns = scanner.nextInt();

            // Check for negative or zero column count
            if (numOfColumns <= 0) {
                throw new InvalidInputException("Number of columns must be a positive integer.");
            }

            int[][] grid = new int[2][numOfColumns];
            System.out.println("Enter the elements of the grid:");

            // Taking input for each element of the grid
            for (int row = 0; row < 2; row++) {
                for (int col = 0; col < numOfColumns; col++) {
                    grid[row][col] = scanner.nextInt();
                }
            }

            // Calculating and printing the maximum sum of non-adjacent elements
            System.out.println("Maximum sum of non-adjacent elements: " + maxSumNoAdjacent(grid));

            scanner.close();
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: An unexpected error occurred.");
        }
    }
}