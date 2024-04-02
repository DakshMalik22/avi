import java.util.*;

public class UniquePathsInMaze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] maze = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    maze[i][j] = scanner.nextInt();
                }
            }
            System.out.println(uniquePaths(maze));
        }
        scanner.close();
    }

    public static int uniquePaths(int[][] maze) {
        int MOD = 1000000007;
        int m = maze.length, n = maze[0].length;
        int[][] dp = new int[m][n];
        
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (maze[i][0] == 0)
                dp[i][0] = dp[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            if (maze[0][j] == 0)
                dp[0][j] = dp[0][j - 1];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (maze[i][j] == 0)
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }
        
        return dp[m - 1][n - 1];
    }
}
