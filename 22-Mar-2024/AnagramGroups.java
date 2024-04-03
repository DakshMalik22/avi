import java.util.*;
//grouping anagrams
public class AnagramGroups {
    
    public static List<List<String>> groupAnagrams(String[] inputStr) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : inputStr) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            
            if (!map.containsKey(sortedStr)) 
                map.put(sortedStr, new ArrayList<>());
            map.get(sortedStr).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
    
    public static void main(String[] args) {
        String[] inputStr1 = {"abab", "baba", "aabb", "abbc"};
        List<List<String>> result1 = groupAnagrams(inputStr1);
        for (List<String> group : result1) {
            System.out.println(group);
        }
        
        String[] inputStr2 = {"aecd", "bcda", "acbd", "abdc", "acda"};
        List<List<String>> result2 = groupAnagrams(inputStr2);
        for (List<String> group : result2) {
            System.out.println(group);
        }
    }
}
