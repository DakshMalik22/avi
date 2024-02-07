package Day_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ques1 {
    public static void main(String[] args) {
        // Input array of strings
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};

        // HashMap to store sorted string as key and corresponding anagrams as values
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        // Iterate through each string in the input array
        for(String s : arr) {
            // Convert the string to a character array
            char[] fnd = s.toCharArray();
            // Sort the character array
            Arrays.sort(fnd);
            // Convert the sorted character array back to string
            String word = new String(fnd);

            // If the sorted string is not already in the map, add it with an empty ArrayList
            map.putIfAbsent(word, new ArrayList<>());
            // Add the original unsorted string to the corresponding ArrayList in the map
            map.get(word).add(s);
        }

        // Iterate through the values of the map (ArrayLists of anagrams) and print them
        for(ArrayList<String> s: map.values()) {
            System.out.print(s);
        }
    }
}
