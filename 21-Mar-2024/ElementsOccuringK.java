import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//counting elements occurance
public class ElementsOccuringK {
    public static void main(String[] args) {
        int[][] arrays = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {5, 5, 5, 5, 5, 5, 6, 6, 6}};
        int[] thresholds = {5, 3};

        for (int i = 0; i < arrays.length; i++) {
            List<Integer> result = findFrequentElements(arrays[i], thresholds[i]);
            System.out.println("Frequent elements for array " + (i + 1) + ": " + result);
        }
    }

    public static List<Integer> findFrequentElements(int[] array, int k) {
        int n = array.length;
        int frequencyThreshold = n / k;

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer> frequentElements = new ArrayList<>();

        // Count frequency of each element
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Check if frequency is greater than or equal to threshold
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() >= frequencyThreshold) {
                frequentElements.add(entry.getKey());
            }
        }

        return frequentElements;
    }
}
