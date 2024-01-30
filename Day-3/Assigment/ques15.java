package Assigment;

public class ques15 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        int target = 3;

        int result = countWaysToAchieveTarget(arr, target);
        System.out.println("Number of ways to achieve the target: " + result);
    }

    private static int countWaysToAchieveTarget(int[] arr, int target) {
        return countWays(arr, target, 0, 0);
    }

    private static int countWays(int[] arr, int target, int currentIndex, int currentSum) {
        // Base case: If we have reached the end of the array
        if (currentIndex == arr.length) {
            return (currentSum == target) ? 1 : 0;
        }

        // Recursive case: Add and subtract the current element and explore all possibilities
        int waysToAdd = countWays(arr, target, currentIndex + 1, currentSum + arr[currentIndex]);
        int waysToSubtract = countWays(arr, target, currentIndex + 1, currentSum - arr[currentIndex]);

        return waysToAdd + waysToSubtract;
    }
}
