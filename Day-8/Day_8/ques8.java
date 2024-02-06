package Day_8;

import java.util.Scanner;

public class ques8 {
    static int find(int n)
    {
        // Base case: If the integer is 0, return 1
        if (n == 0) {
            return 1;
        }

        // Base case: If the integer becomes 0, return 0
        if (n < 10) {
            return 0;
        }

        // Extract the last digit of the number
        int lastDigit = n % 10;

        // Recursively count the zeros in the remaining digits
        int count = find(n / 10);

        // If the last digit is 0, increment the count
        if (lastDigit == 0) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(find(n));
    }
}
