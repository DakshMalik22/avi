package Day_8;

import java.util.Scanner;

public class ques1 {
    // Recursive method to calculate the geometric sum
    public static double power(int n) {
        // Base case: if n is 0, return 1 (the sum of the series when n=0)
        if (n == 0) {
            return 1;
        }

        // Recursive step: calculate the sum recursively
        // Here, we use the formula: 1/(2^n) + power(n-1)
        // This formula adds the current term to the sum of the previous terms
        double xnp = power(n - 1); // Recursively calculate the sum of the previous terms
        double xp = 1 / Math.pow(2, n) + xnp; // Calculate the current term and add it to the sum

        return xp; // Return the total sum
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n = scanner.nextInt();

        // Check if n is non-negative
        if (n < 0) {
            System.out.println("Please enter a non-negative integer.");
        } else {
            // Calculate and print the geometric sum with 5 decimal places
            double ans = power(n);
            System.out.printf("Geometric Sum(%d) = %.5f\n", n, ans);
        }
    }
}
