public class StableHorseAccommodation {
    public int minProductSum(String horses, int K) {
        int n = horses.length();
        int[][] dp = new int[K + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            dp[1][i] = countWhite(horses, 0, i) * countBlack(horses, i, n);
        }

        for (int k = 2; k <= K; k++) {
            for (int i = 1; i <= n; i++) {
                int minProduct = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    minProduct = Math.min(minProduct, dp[k - 1][j] + countWhite(horses, j, i) * countBlack(horses, i, n));
                }
                dp[k][i] = minProduct;
            }
        }

        return dp[K][n];
    }

    private int countWhite(String horses, int start, int end) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (horses.charAt(i) == 'W') {
                count++;
            }
        }
        return count;
    }

    private int countBlack(String horses, int start, int end) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (horses.charAt(i) == 'B') {
                count++;
            }
        }
        return count;
    }
}
