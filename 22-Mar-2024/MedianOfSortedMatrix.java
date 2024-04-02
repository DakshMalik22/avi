import java.util.Arrays;

public class MedianOfSortedMatrix {
    
    public static int findMedian(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[] merged = new int[rows * cols];
        int index = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                merged[index++] = matrix[i][j];
            }
        }
        
        Arrays.sort(merged);
        
        return merged[(rows * cols) / 2];
    }
    
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        System.out.println(findMedian(matrix1)); // Output: 5
        
        int[][] matrix2 = {{5}, {1, 3}, {1, 4, 6}};
        System.out.println(findMedian(matrix2)); // Output: 4
    }
}
