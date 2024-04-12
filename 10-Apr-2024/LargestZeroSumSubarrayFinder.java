import java.util.ArrayList;
import java.util.HashMap;

public class LargestZeroSumSubarrayFinder {
    public ArrayList<Integer> largestZeroSumSubarray(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
        int maxLength = 0;
        int start = -1;
        int end = -1;
        int sum = 0;
        
        sumIndexMap.put(0, -1); // Handle the case when the zero sum subarray starts from index 0
        
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (sumIndexMap.containsKey(sum)) {
                int currentLength = i - sumIndexMap.get(sum);
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    start = sumIndexMap.get(sum) + 1;
                    end = i;
                }
            } else {
                sumIndexMap.put(sum, i);
            }
        }
        
        if (start != -1 && end != -1) {
            for (int i = start; i <= end; i++) {
                result.add(A.get(i));
            }
        }
        
        return result;
    }
}
