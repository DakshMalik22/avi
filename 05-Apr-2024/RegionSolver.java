import java.util.Arrays;

class RegionSolver {

    // Depth-first search to mark connected 'O's as visited
    public void dfs(char[][] board, boolean[][] visited, int row, int col, int rows, int cols) {
        // Base cases for DFS termination
        if (row < 0 || col < 0 || row >= rows || col >= cols || visited[row][col] || board[row][col] == 'X')
            return;

        // Mark the current cell as visited
        visited[row][col] = true;

        // Explore adjacent cells
        dfs(board, visited, row + 1, col, rows, cols); // Down
        dfs(board, visited, row - 1, col, rows, cols); // Up
        dfs(board, visited, row, col + 1, rows, cols); // Right
        dfs(board, visited, row, col - 1, rows, cols); // Left
    }

    // Method to solve the surrounded regions problem
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols]; // Keeps track of visited cells

        // Traverse the first and last rows
        for (int col = 0; col < cols; col++) {
            if (board[0][col] == 'O' && !visited[0][col])
                dfs(board, visited, 0, col, rows, cols); // DFS for cells in the first row

            if (board[rows - 1][col] == 'O' && !visited[rows - 1][col])
                dfs(board, visited, rows - 1, col, rows, cols); // DFS for cells in the last row
        }

        // Traverse the first and last columns
        for (int row = 0; row < rows; row++) {
            if (board[row][0] == 'O' && !visited[row][0])
                dfs(board, visited, row, 0, rows, cols); // DFS for cells in the first column

            if (board[row][cols - 1] == 'O' && !visited[row][cols - 1])
                dfs(board, visited, row, cols - 1, rows, cols); // DFS for cells in the last column
        }

        // Convert surrounded 'O's to 'X's
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!visited[row][col] && board[row][col] == 'O')
                    board[row][col] = 'X';
            }
        }
    }

    public static void main(String[] args) {
        RegionSolver solver = new RegionSolver();

        // Input board
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        // Print the board before solving
        System.out.println("Before solving:");
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }

        // Solve the surrounded regions problem
        solver.solve(board);

        // Print the board after solving
        System.out.println("\nAfter solving:");
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
