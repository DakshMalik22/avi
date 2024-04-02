import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonElementsInMatrixRows {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{2, 4, 6}, {3, 5, 7}, {1, 8, 9}};

        List<Integer> result1 = findCommonElements(matrix1);
        List<Integer> result2 = findCommonElements(matrix2);

        System.out.println("Common elements in matrix1: " + result1); // Output: [2]
        System.out.println("Common elements in matrix2: " + result2); // Output: []
    }

    public static List<Integer> findCommonElements(int[][] matrix) {
        int rows = matrix.length;
        Set<Integer> commonElements = new HashSet<>();

        // Add elements of the first row to the set
        for (int element : matrix[0]) {
            commonElements.add(element);
        }

        // Iterate through each subsequent row and find intersection with the set
        for (int i = 1; i < rows; i++) {
            Set<Integer> currentRowElements = new HashSet<>();
            for (int element : matrix[i]) {
                currentRowElements.add(element);
            }
            // Take intersection of the current row elements with the commonElements set
            commonElements.retainAll(currentRowElements);
        }

        // Convert set to list
        List<Integer> result = new ArrayList<>(commonElements);
        return result;
    }
}
