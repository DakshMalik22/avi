import java.util.HashMap;

public class QuadrupletChecker {

    public static String checkQuadruplet(int[] nums, int target) {
       //length of array
        int n = nums.length;

        // Create a HashMap to store the sum of pairs of elements and their indices
        HashMap<Integer, int[]> pairSumMap = new HashMap<>();

        // Populate the HashMap with the sum of pairs of elements
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                pairSumMap.put(sum, new int[]{i, j});
            }
        }

        // Check for quadruplets
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                int complement = target - sum;

                if (pairSumMap.containsKey(complement)) {
                    int[] indices = pairSumMap.get(complement);
                    // Check if all indices are different
                    if (indices[0] != i && indices[1] != i && indices[0] != j && indices[1] != j) {
                        return "Yes";
                    }
                }
            }
        }

        // No quadruplet found
        return "No";
    }

    public static void main(String[] args) {
        int[][] testCases = {
                {1, 2, 3, 4, 5, 6},
                {2, 4, 6, 8, 10, 12},
                {3, 6, 9, 12, 15, 18},
                {4, 8, 12, 16, 20, 24}
        };
        int[] targets = {12, 24, 30, 32};

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test " + (i + 1) + ": " + checkQuadruplet(testCases[i], targets[i]));
        }
    }
}
