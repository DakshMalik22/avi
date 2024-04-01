
public class MinSumPathTriangle {
    public static int minimumPathSum(int[][] triangle, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
        {
            dp[i] = triangle[n - 1][i];
        }
        for (int i = n - 2; i >= 0; i--)
        {
            for (int j = 0; j <= i ; j++)
            {
                dp[j] = triangle[i][j] + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    public static void main(String[] args)
    {
        int triangle [][] = {{1}, {2,3}, {3,6,7}, {8,9,6,1}};
        System.out.print(minimumPathSum(triangle, triangle.length));
    }
}

