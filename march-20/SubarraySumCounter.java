import java.util.HashMap;
import java.util.Scanner;

public class SubarraySumCounter {
    public static void main(String[] args) {
        //taking input from user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the size of the array:");
        int size = scanner.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter elements of the array:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println("Enter the value of k:");
        int k = scanner.nextInt();
        System.out.println("Count of subarrays with sum equal to k:");
        System.out.println(countSubarraysWithSum(nums, k));
    }

    public static int countSubarraysWithSum(int[] nums, int k) {
        HashMap<Integer, Integer> sumCountMap = new HashMap<>();
        sumCountMap.put(0, 1); // Identity element
        int currentSum = 0;
        int totalCount = 0;
        for (int num : nums) {
            currentSum += num;
            int remainder = currentSum - k;
            if (sumCountMap.containsKey(remainder)) {
                totalCount += sumCountMap.get(remainder);
            }
            sumCountMap.put(currentSum, sumCountMap.getOrDefault(currentSum, 0) + 1);
        }
        return totalCount;
    }
}
