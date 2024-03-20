import java.util.*;

public class LongestSubarrayWithZeroSum {
    public static int longestSubarrayWithZeroSum(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (nums[i] == 0 && maxLength == 0)
                maxLength = 1;

            if (sum == 0)
                maxLength = i + 1;

            if (sumIndexMap.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - sumIndexMap.get(sum));
            } else {
                sumIndexMap.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {95, -97, -387, -435, -5, -70, 897, 127, 23, 284};
        System.out.println(longestSubarrayWithZeroSum(nums));
    }
}

