import java.util.Arrays;

class RegionSolver {
    public void depthFirstSearch(char[][] area, boolean[][] visited, int row, int col, int numRows, int numCols) {
        if (row < 0 || col < 0 || row >= numRows || col >= numCols || visited[row][col] || area[row][col] == 'X')
            return;
        visited[row][col] = true;
        depthFirstSearch(area, visited, row + 1, col, numRows, numCols);
        depthFirstSearch(area, visited, row - 1, col, numRows, numCols);
        depthFirstSearch(area, visited, row, col + 1, numRows, numCols);
        depthFirstSearch(area, visited, row, col - 1, numRows, numCols);
    }

    public void solveRegions(char[][] area) {
        int numRows = area.length;
        int numCols = area[0].length;
        boolean visited[][] = new boolean[numRows][numCols];
        for (int col = 0; col < numCols; col++) {
            if (area[0][col] == 'O' && !visited[0][col])
                depthFirstSearch(area, visited, 0, col, numRows, numCols);
            if (area[numRows - 1][col] == 'O' && !visited[numRows - 1][col])
                depthFirstSearch(area, visited, numRows - 1, col, numRows, numCols);
        }
        for (int row = 0; row < numRows; row++) {
            if (area[row][0] == 'O' && !visited[row][0])
                depthFirstSearch(area, visited, row, 0, numRows, numCols);
            if (area[row][numCols - 1] == 'O' && !visited[row][numCols - 1])
                depthFirstSearch(area, visited, row, numCols - 1, numRows, numCols);
        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (!visited[i][j] && area[i][j] == 'O')
                    area[i][j] = 'X';
            }
        }
    }

    public static void main(String[] args) {
        RegionSolver solver = new RegionSolver();

        char[][] area = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        System.out.println("Before solving:");
        for (char[] row : area) {
            System.out.println(Arrays.toString(row));
        }

        solver.solveRegions(area);

        System.out.println("\nAfter solving:");
        for (char[] row : area) {
            System.out.println(Arrays.toString(row));
        }
    }
}
