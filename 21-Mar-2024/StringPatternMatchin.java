import java.util.ArrayList;
import java.util.List;

public class StringPatternMatching {
    
    public static List<Integer> findPatternOccurrences(String text, String pattern) {
        List<Integer> occurrences = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        
        // Construct the prefix array for the pattern
        int[] prefixArray = new int[m];
        int j = 0;
        for (int i = 1; i < m; i++) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                prefixArray[i] = j;
            } else {
                if (j != 0) {
                    j = prefixArray[j - 1];
                    i--;
                } else {
                    prefixArray[i] = 0;
                }
            }
        }
        
        // Perform pattern matching using the prefix array
        int i = 0;
        j = 0;
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                occurrences.add(i - j + 1);
                j = prefixArray[j - 1];
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0)
                    j = prefixArray[j - 1];
                else
                    i++;
            }
        }
        
        return occurrences;
    }
    
    public static void main(String[] args) {
        String text1 = "cxyzghxyzvjkxyz";
        String pattern1 = "xyz";
        List<Integer> occurrences1 = findPatternOccurrences(text1, pattern1);
        System.out.println(occurrences1); // Output: [2, 7, 13]
        
        String text2 = "ababacabab";
        String pattern2 = "aba";
        List<Integer> occurrences2 = findPatternOccurrences(text2, pattern2);
        System.out.println(occurrences2); // Output: [1, 3, 7]
        
        String text3 = "abcd";
        String pattern3 = "xy";
        List<Integer> occurrences3 = findPatternOccurrences(text3, pattern3);
        System.out.println(occurrences3); // Output: []
    }
}
