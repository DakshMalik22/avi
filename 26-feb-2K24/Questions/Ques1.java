package Questions;

import java.util.Scanner;
import java.util.Vector;

public class Ques1 {
    public static void main(String[] args) {
       
        Vector<Integer> vec = new Vector<>();
        
        // Creating a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);
        
        // Reading the size of the vector and window size from the user
        int size = scanner.nextInt();
        int windSize = scanner.nextInt();

        // Reading the elements of the vector from the user
        for (int i = 0; i < size; i++) {
            vec.add(scanner.nextInt());
        }

        // Initializing pointers and variables for window sliding
        int i = 0; // Start of the window
        int j = 0; // End of the window
        int sum = 0; // Sum of elements in the current window
        Vector<Integer> ans = new Vector<>(); // Vector to store the averages of windows

        // Sliding the window until the end of the vector is reached
        while (j < size) {
            // If the window size is less than the specified window size, expand the window
            if (j - i + 1 < windSize) {
                sum += vec.get(j);
                j++;
            }

            // If the window size is equal to the specified window size, calculate the average and add it to the result
            if (j - i + 1 == windSize) {
                sum += vec.get(j);
                int avg = sum / windSize; // Calculate the average
                ans.add(avg); // Add the average to the result vector
                j++;
                i++;
            }
        }

        // Printing the result vector containing the averages of the windows
        System.out.println(ans.toString());
    }
}
