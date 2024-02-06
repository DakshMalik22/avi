package Day_8;

public class ques4 {
    // Recursive method to find and modify consecutive duplicate characters in a string
    public static void find(String s, StringBuilder sc, int i) {
        // Base case: If the index exceeds or equals the length of the string, print the modified string
        if (i >= s.length()) {
            System.out.println(sc);
            return;
        }

        // Check if the current character is equal to the previous character
        if (s.charAt(i) == s.charAt(i - 1)) {
            // If consecutive duplicate characters are found, append '*' before adding the character to the StringBuilder
            sc.append('*');
            sc.append(s.charAt(i));
        } else {
            // If the current character is not equal to the previous character, simply append it to the StringBuilder
            sc.append(s.charAt(i));
        }

        // Recursively process the next character in the string
        find(s, sc, i + 1);
    }

    public static void main(String[] args) {
        // Input string
        String s = "hello";

        // StringBuilder to store the modified string
        StringBuilder sc = new StringBuilder();

        // Start from index 1, as we have already processed the first character in the string
        int i = 1;

        // Append the first character of the input string to the StringBuilder
        sc.append(s.charAt(0));

        // Call the recursive method to find and modify consecutive duplicate characters
        find(s, sc, i);
    }
}
