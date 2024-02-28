package Questions;

public class GasStation {
    public static void main(String[] args) {
        // Petrol available at each station
        int[] petrol = {4, 6, 7, 4};
        
        // Distance to next station from each station
        int[] distance = {6, 5, 3, 5};
        
        int balance = 0; // Initialize balance of petrol
        int deficit = 0; // Initialize deficit of petrol
        int start = 0; // Initialize start index of the circular route

        // Iterate over each station
        for (int i = 0; i < petrol.length; i++) {
            // Calculate balance of petrol after reaching current station
            balance += petrol[i] - distance[i];
            
            // If balance becomes negative, there's a deficit
            if (balance < 0) {
                deficit += balance; // Update total deficit
                start = i + 1; // Update start index for next attempt
                balance = 0; // Reset balance to 0 for next attempt
            }
        }

        // If total balance plus total deficit is non-negative, there exists a solution
        if (balance + deficit >= 0) {
            System.out.println(start); // Print the starting index of the circular route
        } else {
            System.out.println("-1"); // Otherwise, no solution exists
        }
    }
}
