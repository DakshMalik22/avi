import java.util.*;

public class InterleavingChecker {
    public int isInterleave(String firstString, String secondString, String targetString) {
        int m = firstString.length();
        int n = secondString.length();
        
        // If sum of lengths of firstString and secondString is not equal to length of targetString,
        // targetString cannot be formed by interleaving firstString and secondString
        if (m + n != targetString.length())
            return 0;
        
        // dp[i][j] will be true if targetString[0..i+j-1] is an interleaving of firstString[0..i-1] and secondString[0..j-1].
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base cases
        dp[0][0] = true;
        
        // Fill dp[][] in bottom up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If both firstString and secondString are empty, then targetString must also be empty, so result is true
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                // If firstString is empty, check if previous secondString character matches current targetString character
                else if (i == 0)
                    dp[i][j] = (dp[i][j - 1] && secondString.charAt(j - 1) == targetString.charAt(i + j - 1));
                // If secondString is empty, check if previous firstString character matches current targetString character
                else if (j == 0)
                    dp[i][j] = (dp[i - 1][j] && firstString.charAt(i - 1) == targetString.charAt(i + j - 1));
                // If both firstString and secondString are non-empty, check if either previous firstString character or previous secondString character matches current targetString character
                else
                    dp[i][j] = (dp[i - 1][j] && firstString.charAt(i - 1) == targetString.charAt(i + j - 1)) || 
                               (dp[i][j - 1] && secondString.charAt(j - 1) == targetString.charAt(i + j - 1));
            }
        }
        
        return dp[m][n] ? 1 : 0;
    }
    
    public static void main(String[] args) {
        InterleavingChecker checker = new InterleavingChecker();
        
        // Example usage:
        String firstString1 = "aabcc";
        String secondString1 = "dbbca";
        String targetString1 = "aadbbcbcac";
        System.out.println(checker.isInterleave(firstString1, secondString1, targetString1)); // Output: 1
        
        String firstString2 = "aabcc";
        String secondString2 = "dbbca";
        String targetString2 = "aadbbbaccc";
        System.out.println(checker.isInterleave(firstString2, secondString2, targetString2)); // Output: 0
    }
}
