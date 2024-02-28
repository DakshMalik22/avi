package Questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ques3 {
    // Method to check if two strings are scramble of each other
    public int isScramble(final String A, final String B) {
        // If lengths are different or they are not anagrams, return 0
        if (A.length() != B.length() || !isAnagram(A, B)) {
            return 0;
        }

        // If both strings are same, return 1
        if (A.equals(B)) {
            return 1;
        }

        // Initialize a map for memoization
        Map<String, Integer> memo = new HashMap<>();
        // Call the helper method for recursive scrambling check
        return isScrambleHelper(A, B, memo);
    }

    // Helper method for recursive scrambling check
    private int isScrambleHelper(String A, String B, Map<String, Integer> memo) {
        // If both strings are same, return 1
        if (A.equals(B)) {
            return 1;
        }

        // If either string is of length 1, they can't be scrambled
        if (A.length() <= 1) {
            return 0;
        }

        // Generate a unique key for memoization
        String key = A + "-" + B;
        // If the key is already memoized, return the value
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int n = A.length();
        // Try all possible splitting points
        for (int i = 1; i < n; i++) {
            if ((isScrambleHelper(A.substring(0, i), B.substring(0, i), memo) == 1 &&
                    isScrambleHelper(A.substring(i), B.substring(i), memo) == 1) ||
                    (isScrambleHelper(A.substring(0, i), B.substring(n - i), memo) == 1 &&
                            isScrambleHelper(A.substring(i), B.substring(0, n - i), memo) == 1)) {
                // If any split results in valid scramble, memoize and return 1
                memo.put(key, 1);
                return 1;
            }
        }

        // Memoize and return 0 if no valid scramble found
        memo.put(key, 0);
        return 0;
    }

    // Method to check if two strings are anagrams
    private boolean isAnagram(String A, String B) {
        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();
        Arrays.sort(charsA);
        Arrays.sort(charsB);
        return Arrays.equals(charsA, charsB);
    }

    // Main method to take input and test the solution
    public static void main(String[] args) {
        ques3 solution = new ques3();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String 1 : ");
        String string1 = sc.next();
        System.out.println("Enter String 2 : ");
        String string2 = sc.next();
        // Call the isScramble method and print the result
        System.out.println(solution.isScramble(string1, string2));
    }
}
