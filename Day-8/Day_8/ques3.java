package Day_8;

public class ques3 {
    // Recursive method to convert a string of digits to an integer
    public static int ans(String s, int i, int store) {
        // Base case: If we have processed all characters in the string, return the final store value
        if (i == s.length()) {
            return store;
        }

        // Update the store value by appending the current digit to it
        store = store * 10 + (s.charAt(i) - '0');

        // Recursively process the next character in the string
        return ans(s, i + 1, store);
    }

    public static void main(String[] args) {
        // Input string containing digits
        String s = "00012567";

        // Initialize variables for recursion
        int i = 0;
        int store = 0;

        // Call the recursive function and store its result
        int ans1 = ans(s, i, store);

        // Print the final value obtained after conversion
        System.out.println(ans1);
    }
}
