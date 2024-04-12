import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumbersInWindowCounter {
    public ArrayList<Integer> countDistinctNumbers(ArrayList<Integer> numbers, int windowSize) {
        ArrayList<Integer> result = new ArrayList<>();
        if (windowSize > numbers.size()) return result;
        
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Count the frequency of elements in the first window
        for (int i = 0; i < windowSize; i++) {
            frequencyMap.put(numbers.get(i), frequencyMap.getOrDefault(numbers.get(i), 0) + 1);
        }
        
        result.add(frequencyMap.size());
        
        // Slide the window and update frequency map accordingly
        for (int i = windowSize; i < numbers.size(); i++) {
            int prevElement = numbers.get(i - windowSize);
            int currElement = numbers.get(i);
            
            frequencyMap.put(prevElement, frequencyMap.get(prevElement) - 1);
            if (frequencyMap.get(prevElement) == 0) {
                frequencyMap.remove(prevElement);
            }
            
            frequencyMap.put(currElement, frequencyMap.getOrDefault(currElement, 0) + 1);
            result.add(frequencyMap.size());
        }
        
        return result;
    }
}
