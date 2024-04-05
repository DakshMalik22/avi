import java.util.Arrays;

public class ClosestSumFinder {
    public int findClosestSum(int[] nums, int target) {
        // Sort the array to utilize two-pointer technique
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE;
        int minDifference = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int difference = Math.abs(sum - target);
                
                // Update closest sum if current sum is closer to target
                if (difference < minDifference) {
                    minDifference = difference;
                    closestSum = sum;
                }
                
                // If current sum is greater than target, decrease right pointer
                if (sum > target)
                    right--;
                // If current sum is less than target, increase left pointer
                else
                    left++;
            }
        }
        
        return closestSum;
    }
    
    public static void main(String[] args) {
        ClosestSumFinder solution = new ClosestSumFinder();
        
        // Example usage:
        int[] nums1 = {-1, 2, 1, -4};
        int target1 = 1;
        System.out.println(solution.findClosestSum(nums1, target1)); // Output: 2
        
        int[] nums2 = {1, 2, 3};
        int target2 = 6;
        System.out.println(solution.findClosestSum(nums2, target2)); // Output: 6
    }
}
