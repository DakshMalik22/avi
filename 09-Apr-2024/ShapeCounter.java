package com.example;

import java.util.ArrayList;
import java.util.Stack;

public class ShapeCounter {

    class Position {
        int row, col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static final int[] ROW_MOVES = {-1, 1, 0, 0};
    private static final int[] COL_MOVES = {0, 0, -1, 1};

    private boolean isValidPosition(int row, int col, boolean[][] visited, int numRows, int numCols, ArrayList<String> grid) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols && !visited[row][col] && grid.get(row).charAt(col) == 'X';
    }

    private void dfs(Stack<Position> stack, boolean[][] visited, ArrayList<String> grid, int row, int col, int numRows, int numCols) {
        stack.push(new Position(row, col));
        visited[row][col] = true;

        while (!stack.isEmpty()) {
            Position currentPosition = stack.pop();
            int currentRow = currentPosition.row;
            int currentCol = currentPosition.col;

            for (int i = 0; i < 4; i++) {
                int newRow = currentRow + ROW_MOVES[i];
                int newCol = currentCol + COL_MOVES[i];

                if (isValidPosition(newRow, newCol, visited, numRows, numCols, grid)) {
                    stack.push(new Position(newRow, newCol));
                    visited[newRow][newCol] = true;
                }
            }
        }
    }

    public int countShapes(ArrayList<String> grid) {
        int numRows = grid.size();
        int numCols = grid.get(0).length();
        Stack<Position> stack = new Stack<>();
        int shapeCount = 0;
        boolean[][] visited = new boolean[numRows][numCols];

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (!visited[row][col] && grid.get(row).charAt(col) == 'X') {
                    shapeCount++;
                    dfs(stack, visited, grid, row, col, numRows, numCols);
                }
            }
        }
        return shapeCount;
    }

    public static void main(String[] args) {
        ShapeCounter shapeCounter = new ShapeCounter();
        ArrayList<String> grid = new ArrayList<>();
        grid.add("OOOXOOO");
        grid.add("OOXXOXO");
        grid.add("OXOOOXO");

        int result = shapeCounter.countShapes(grid);
        System.out.println("Number of shapes: " + result);
    }
}
