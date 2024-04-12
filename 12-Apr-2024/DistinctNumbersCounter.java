import java.util.*;

public class DistinctNumbersCounter {
    public ArrayList<Integer> countDistinctNumbers(ArrayList<Integer> numbers, int windowSize) {
        ArrayList<Integer> result = new ArrayList<>();
        if (windowSize > numbers.size()) return result;
        
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int distinctCount = 0;
        
        for (int i = 0; i < windowSize; i++) {
            if (frequencyMap.getOrDefault(numbers.get(i), 0) == 0) {
                distinctCount++;
            }
            frequencyMap.put(numbers.get(i), frequencyMap.getOrDefault(numbers.get(i), 0) + 1);
        }
        
        result.add(distinctCount);
        
        for (int i = windowSize; i < numbers.size(); i++) {
            int leftElement = numbers.get(i - windowSize);
            if (frequencyMap.get(leftElement) == 1) {
                distinctCount--;
            }
            frequencyMap.put(leftElement, frequencyMap.get(leftElement) - 1);
            
            int rightElement = numbers.get(i);
            if (frequencyMap.getOrDefault(rightElement, 0) == 0) {
                distinctCount++;
            }
            frequencyMap.put(rightElement, frequencyMap.getOrDefault(rightElement, 0) + 1);
            
            result.add(distinctCount);
        }
        
        return result;
    }
}
