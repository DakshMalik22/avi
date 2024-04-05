import java.util.*;

public class Solution {
    public int isInterleave(String A, String B, String C) {
        int m = A.length();
        int n = B.length();
        
        // If sum of lengths of A and B is not equal to length of C, C cannot be formed by interleaving A and B
        if (m + n != C.length())
            return 0;
        
        // dp[i][j] will be true if C[0..i+j-1] is an interleaving of A[0..i-1] and B[0..j-1].
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base cases
        dp[0][0] = true;
        
        // Fill dp[][] in bottom up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If both A and B are empty, then C must also be empty, so result is true
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                // If A is empty, check if previous B character matches current C character
                else if (i == 0)
                    dp[i][j] = (dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1));
                // If B is empty, check if previous A character matches current C character
                else if (j == 0)
                    dp[i][j] = (dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1));
                // If both A and B are non-empty, check if either previous A character or previous B character matches current C character
                else
                    dp[i][j] = (dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1)) || (dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1));
            }
        }
        
        return dp[m][n] ? 1 : 0;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example usage:
        String A1 = "aabcc";
        String B1 = "dbbca";
        String C1 = "aadbbcbcac";
        System.out.println(solution.isInterleave(A1, B1, C1)); // Output: 1
        
        String A2 = "aabcc";
        String B2 = "dbbca";
        String C2 = "aadbbbaccc";
        System.out.println(solution.isInterleave(A2, B2, C2)); // Output: 0
    }
}
