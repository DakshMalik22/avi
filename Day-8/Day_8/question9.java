package Day_8;
//9.Problem statement
//For a given array with N elements, you need to find the length of the longest subsequence from the array such that all the elements of the subsequence are sorted in strictly increasing order.
//
//Strictly Increasing Sequence is when each term in the sequence is larger than the preceding term.
//
//For example:
//[1, 2, 3, 4] is a strictly increasing array, while [2, 1, 4, 3] is not.
public class question9 {
    public static int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        // Initialize dp array with 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Calculate longest increasing subsequence lengths
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // Find the maximum value in the dp array
        int maxLen = 0;
        for (int len : dp) {
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 4, 11, 1, 16, 8};
        int[] nums2 = {1, 2, 2};

        System.out.println("Sample Output 1: " + longestIncreasingSubsequence(nums1)); // Output: 3
        System.out.println("Sample Output 2: " + longestIncreasingSubsequence(nums2)); // Output: 2
    }
}
