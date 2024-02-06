package Day_8;

import java.util.Scanner;

public class ques6 {
    // Recursive method to calculate the sum of digits of a number
    static void ans(int x, int sum) {
        // Base case: If the number becomes 0, print the sum and return
        if (x == 0) {
            System.out.println(sum);
            return;
        }

        // Recursively call the method with the quotient of x divided by 10 and the sum plus the remainder of x divided by 10
        ans(x / 10, (sum + x % 10));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        // Initial values for count and pointer are not used, consider removing them
        int count = 0;
        int pointer = 0;

        // Call the recursive method to calculate the sum of digits of the input number
        ans(x, count);
    }
}
