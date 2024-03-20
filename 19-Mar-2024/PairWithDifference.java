
import java.util.*;

public class PairWithDifference {
    public static int countPairsWithDifferenceK(int[] nums, int k) {
        Set<Integer> numSet = new HashSet<>();
        int count = 0;

        for (int num : nums) {
            if (numSet.contains(num - k))
                count++;
            if (numSet.contains(num + k))
                count++;
            numSet.add(num);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {5,1,2,4};
        int k = 3;
        System.out.println(countPairsWithDifferenceK(nums, k));
    }
}
