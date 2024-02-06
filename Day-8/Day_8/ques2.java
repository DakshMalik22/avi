package Day_8;

import java.util.Scanner;

public class ques2 {

    // Recursive method to check if a string is a palindrome
    public static boolean palindrome(String s, int i, int j) {
        // Base case: If the indices cross each other or overlap, the string is a palindrome
        if (i >= j) {
            return true;
        }

        // Check if the characters at indices i and j are equal
        if (s.charAt(i) != s.charAt(j)) {
            return false; // If they're not equal, the string is not a palindrome
        }

        // Recursive step: Move i to the right and j to the left, and check the next characters
        return palindrome(s, i + 1, --j);
    }

    public static void main(String[] args) {
        // Input string to check for palindrome
        String s = "abba";

        // Initialize starting and ending indices of the string
        int i = 0;
        int j = s.length() - 1;

        // Call the palindrome method and store the result in a boolean variable
        boolean check = palindrome(s, i, j);

        // Print the result
        System.out.println("Is the string a palindrome "+s+ " ?" + check);
    }
}
