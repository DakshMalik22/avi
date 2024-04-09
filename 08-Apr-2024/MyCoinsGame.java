import java.util.ArrayList;
import java.util.Arrays;

public class MyCoinsGame {
    public int getMaxCoins(ArrayList<Integer> coinsList) {
        int n = coinsList.size();
        int[][] dp = new int[n][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return findMaxCoins(dp, coinsList, 0, n - 1);
    }

    int findMaxCoins(int[][] dp, ArrayList<Integer> coinsList, int start, int end) {
        if (start > end) {
            return 0;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        dp[start][end] = Math.max(coinsList.get(start) + Math.min(findMaxCoins(dp, coinsList, start + 2, end), findMaxCoins(dp, coinsList, start + 1, end - 1)),
                coinsList.get(end) + Math.min(findMaxCoins(dp, coinsList, start + 1, end - 1), findMaxCoins(dp, coinsList, start, end - 2)));
        return dp[start][end];
    }

    public static void main(String[] args) {
        ArrayList<Integer> coins = new ArrayList<>();
        coins.add(5);
        coins.add(4);
        coins.add(8);
        coins.add(10);

        MyCoinsGame game = new MyCoinsGame();
        System.out.println(game.getMaxCoins(coins));
    }
}
