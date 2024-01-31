package Day_4;

import java.util.HashMap;

public class ques7 {

    public static void main(String[] args) {
        HashMap<Character,Integer>map = new HashMap<>();
        String ans = "abdefgbabfba";
        for(int i=0;i<ans.length();i++)
        {
            if(map.containsKey(ans.charAt(i)))
            {
                map.put(ans.charAt(i), map.get(ans.charAt(i))+1);
            }
            else
            {
                map.put(ans.charAt(i),1);
            }
        }
        int max=0;

        for(char c:map.keySet())
        {
            if(map.get(c)>max)
            {
                max=map.get(c);
            }

        }
        for(char c:map.keySet())
        {
            if(map.get(c)==max)
            {
                System.out.println(c);
            }
        }


    }
}
