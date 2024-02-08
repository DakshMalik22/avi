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

       
        System.out.println(Ans(wordList, inputString));
    }

    // Function to determine if inputString can be segmented into words from wordList
    private static boolean Ans(ArrayList<String> wordList, String inputString) {
        // If the wordList contains the entire inputString, returning true
        if (wordList.contains(inputString)) {
            return true;
        }

        // Iterating through the characters of inputString
        for (int i = 0; i < inputString.length(); i++) {
            // Get the substring from the beginning up to index i
            String check = inputString.substring(0, i);

            // If the wordList contains the substring
            if (wordList.contains(check)) {
                // Recursively call the function with the remaining substring
                return Ans(wordList, inputString.substring(i));
            }
        }
        // If no segmentation is possible, returning false
        return false;
    }
}
