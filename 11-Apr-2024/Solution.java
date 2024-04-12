import java.util.Arrays;

public class Solution {
    public int coinchange2(int[] A, int B) {
        int MOD = 1000007;
        int[] dp = new int[B + 1];
        dp[0] = 1;
        
        for (int coin : A) {
            for (int j = coin; j <= B; j++) {
                dp[j] = (dp[j] + dp[j - coin]) % MOD;
            }
        }
        
        return dp[B];
    }
}
