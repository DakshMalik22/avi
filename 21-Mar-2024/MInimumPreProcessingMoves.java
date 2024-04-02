import java.util.Scanner;

public class MinimumPreprocessingMoves {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter string A:");
        String A = scanner.next();
        System.out.println("Enter string B:");
        String B = scanner.next();

        int result = calculateMinPreprocessingMoves(A, B);
        System.out.println("Minimum preprocessing moves required: " + result);

        scanner.close();
    }

    public static int calculateMinPreprocessingMoves(String A, String B) {
        if (A.length() != B.length()) {
            return -1; // Strings need to be of equal length
        }
        
        // Arrays to store count of each character in strings A and B
        int[] charCountA = new int[26];
        int[] charCountB = new int[26];

        // Count occurrences of each character in strings A and B
        for (int i = 0; i < A.length(); i++) {
            charCountA[A.charAt(i) - 'a']++;
            charCountB[B.charAt(i) - 'a']++;
        }

        // Calculate the minimum number of moves required for preprocessing
        int preprocessMoves = 0;
        for (int i = 0; i < 26; i++) {
            preprocessMoves += Math.abs(charCountA[i] - charCountB[i]);
        }

        // Each move affects two characters, so divide by 2 to get the actual number of moves
        return preprocessMoves / 2;
    }
}
