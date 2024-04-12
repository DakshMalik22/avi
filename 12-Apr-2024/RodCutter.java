import java.util.*;

public class RodCutter {
    public ArrayList<Integer> minimizeCost(int rodLength, ArrayList<Integer> weakPoints) {
        ArrayList<Integer> result = new ArrayList<>();
        weakPoints.add(0, 0);
        weakPoints.add(rodLength);
        Collections.sort(weakPoints);
        int n = weakPoints.size();

        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++) {
            for (int left = 0; left < n - len; left++) {
                int right = left + len;
                dp[left][right] = Integer.MAX_VALUE;
                for (int k = left + 1; k < right; k++) {
                    dp[left][right] = Math.min(dp[left][right], dp[left][k] + dp[k][right] + weakPoints.get(right) - weakPoints.get(left));
                }
            }
        }

        getCutOrder(0, n - 1, dp, weakPoints, result);
        return result;
    }

    private void getCutOrder(int left, int right, int[][] dp, ArrayList<Integer> weakPoints, ArrayList<Integer> result) {
        if (left + 1 >= right) return;
        int minCost = dp[left][right];
        for (int k = left + 1; k < right; k++) {
            if (dp[left][k] + dp[k][right] + weakPoints.get(right) - weakPoints.get(left) == minCost) {
                result.add(weakPoints.get(k));
                getCutOrder(left, k, dp, weakPoints, result);
                getCutOrder(k, right, dp, weakPoints, result);
                return;
            }
        }
    }
}
