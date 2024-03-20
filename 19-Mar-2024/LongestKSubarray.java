import java.util.*;

public class LongestKSubarray {
    public static int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0;
        Deque<Integer> maxQueue = new ArrayDeque<>();
        Deque<Integer> minQueue = new ArrayDeque<>();

        int left = 0;
        for (int right = 0; right < n; right++) {
            while (!maxQueue.isEmpty() && nums[right] > maxQueue.peekLast())
                maxQueue.removeLast();
            while (!minQueue.isEmpty() && nums[right] < minQueue.peekLast())
                minQueue.removeLast();

            maxQueue.add(nums[right]);
            minQueue.add(nums[right]);

            while (maxQueue.getFirst() - minQueue.getFirst() > k) {
                if (maxQueue.getFirst() == nums[left])
                    maxQueue.removeFirst();
                if (minQueue.getFirst() == nums[left])
                    minQueue.removeFirst();
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,3,2,7};
        int k = 3;
        System.out.println(longestSubarray(nums, k));
    }
}

