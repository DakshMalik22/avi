package javaBasics.date_04_04_24;

class StringInterleaved {

    static int lengthA, lengthB;
    static int[][] dp = new int[100][100];

    // Depth-first search to find if string C is interleaved from strings A and B
    public static int dfs(int indexA, int indexB, String A, String B, String C) {
        // If already computed, return the result
        if (dp[indexA][indexB] != -1)
            return dp[indexA][indexB];
        
        // If both strings A and B are consumed, return true if C is also consumed
        if (indexA == lengthA && indexB == lengthB)
            return 1;

        // Check if the current character of A matches the corresponding character of C
        if (indexA < lengthA && A.charAt(indexA) == C.charAt(indexA + indexB) && indexB < lengthB
                && B.charAt(indexB) == C.charAt(indexA + indexB)) {
            // Recursive call for both possibilities of choosing from A and B
            int x = dfs(indexA + 1, indexB, A, B, C);
            int y = dfs(indexA, indexB + 1, A, B, C);

            // Update DP table with the result of OR operation
            return dp[indexA][indexB] = x | y;
        }

        // Check if the current character of A matches the corresponding character of C
        if (indexA < lengthA && A.charAt(indexA) == C.charAt(indexA + indexB)) {
            // Recursive call for A
            int x = dfs(indexA + 1, indexB, A, B, C);

            // Update DP table with the result
            return dp[indexA][indexB] = x;
        }

        // Check if the current character of B matches the corresponding character of C
        if (indexB < lengthB && B.charAt(indexB) == C.charAt(indexA + indexB)) {
            // Recursive call for B
            int y = dfs(indexA, indexB + 1, A, B, C);
            
            // Update DP table with the result
            return dp[indexA][indexB] = y;
        }
        // If none of the above conditions are satisfied, return false
        return dp[indexA][indexB] = 0;
    }

    // Method to check if strings A and B can interleave to form string C
    public static int isInterleave(String A, String B, String C) {
        lengthA = A.length();
        lengthB = B.length();

        // If total lengths of A and B do not match with C, return false
        if ((lengthA + lengthB) != C.length())
            return 0;

        // Initialize DP table with -1
        for (int i = 0; i <= lengthA; i++)
            for (int j = 0; j <= lengthB; j++)
                dp[i][j] = -1;

        // Start DFS from index 0 of A and B
        return dfs(0, 0, A, B, C);
    }

    // Method to test if strings A and B can interleave to form string C
    public static void test(String A, String B, String C) {
        // If the strings can interleave, print 1; otherwise, print 0
        if (isInterleave(A, B, C) != 0)
            System.out.println(1);
        else
            System.out.println(0);
    }

    public static void main(String[] args) {
        // Test with sample input
        test("aabcc", "dbbca", "aadbbbaccc");
    }
}
