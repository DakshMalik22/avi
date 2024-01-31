package Day_4;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ques8 {
    public static void main(String[] args) {
        LinkedHashMap<Character,Integer>map = new LinkedHashMap<>();
        String s = "ggggfffeed";

        for(int i=0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                map.put(s.charAt(i) ,map.get(s.charAt(i))+1);
            }
            else {
                map.put(s.charAt(i),1);
            }
        }
        StringBuilder arr = new StringBuilder();

        for(char c:map.keySet())
        {
            if(map.get(c)>1)
            {
                arr.append(c);
                arr.append(map.get(c));
            }
            else
            {
                arr.append(c);
            }
        }
        System.out.println(arr.toString());
    }
}
