import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EqualAveragePartition {
    public ArrayList<ArrayList<Integer>> equalAveragePartition(ArrayList<Integer> A) {
        int n = A.size();
        int sum = 0;
        for (int num : A) {
            sum += num;
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        for (int lenA = 1; lenA <= n / 2; lenA++) {
            if ((sum * lenA) % n == 0) {
                ArrayList<Integer> partitionA = new ArrayList<>();
                if (isPossiblePartition(A, sum * lenA / n, lenA, 0, partitionA)) {
                    ArrayList<Integer> partitionB = new ArrayList<>(A);
                    partitionB.removeAll(partitionA);
                    result.add(partitionA);
                    result.add(partitionB);
                    return result;
                }
            }
        }
        
        return result;
    }
    
    private boolean isPossiblePartition(ArrayList<Integer> A, int targetSum, int len, int start, ArrayList<Integer> partition) {
        if (len == 0) {
            return targetSum == 0;
        }
        
        for (int i = start; i < A.size(); i++) {
            partition.add(A.get(i));
            if (isPossiblePartition(A, targetSum - A.get(i), len - 1, i + 1, partition)) {
                return true;
            }
            partition.remove(partition.size() - 1);
        }
        
        return false;
    }
}
