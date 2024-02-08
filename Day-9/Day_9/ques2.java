package Day_9;

import java.util.ArrayList;

public class ques2 {
    public static void main(String[] args) {
     
        ArrayList<String> wordList = new ArrayList<>();
        wordList.add("cats");
        wordList.add("dog");
        wordList.add("sand");
        wordList.add("and");
        wordList.add("cat");

        
        String inputString = "catsandog";

       
        System.out.println(ans(wordList, inputString));
    }

    // Function to determine if inputString can be segmented into words from wordList
    private static boolean ans(ArrayList<String> wordList, String inputString) {
        // If the wordList contains the entire inputString, return true
        if (wordList.contains(inputString)) {
            return true;
        }

        // Iterate through the characters of inputString
        for (int i = 0; i < inputString.length(); i++) {
            // Get the substring from the beginning up to index i
            String check = inputString.substring(0, i);

            // If the wordList contains the substring
            if (wordList.contains(check)) {
                // Recursively call the function with the remaining substring
                return ans(wordList, inputString.substring(i));
            }
        }
        // If no segmentation is possible, return false
        return false;
    }
}
