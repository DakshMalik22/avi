import java.util.*;

public class CommonElementsInRows {
    public static List<Integer> findCommonElements(int[][] matrix) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int num : matrix[0]) {
            frequencyMap.put(num, 1);
        }
        for (int i = 1; i < rows; i++) {
            for (int num : matrix[i]) {
                if (frequencyMap.containsKey(num) && frequencyMap.get(num) == i) {
                    frequencyMap.put(num, i + 1);
                }
            }
        }
        List<Integer> commonElements = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == rows) {
                commonElements.add(entry.getKey());
            }
        }
        return commonElements;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] matrix = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            List<Integer> result = findCommonElements(matrix);
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
