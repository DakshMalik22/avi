import java.util.HashMap;
// function for  LongestSubstringDistinctK
public class LongestSubstringDistinctK {
    
    public static int longestSubstringLength(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) 
            return 0;
        
        int[] count = new int[256];
        int numDistinct = 0;
        int start = 0;
        int maxLength = 0;
        
        for (int end = 0; end < s.length(); end++) {
            if (count[s.charAt(end)] == 0) 
                numDistinct++;
            count[s.charAt(end)]++;
            
            while (numDistinct > k) {
                count[s.charAt(start)]--;
                if (count[s.charAt(start)] == 0) 
                    numDistinct--;
                start++;
            }
            
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        String s1 = "abcba";
        int k1 = 2;
        System.out.println(longestSubstringLength(s1, k1)); // Output: 3
        
        String s2 = "abccc";
        int k2 = 1;
        System.out.println(longestSubstringLength(s2, k2)); // Output: 3
    }
}
