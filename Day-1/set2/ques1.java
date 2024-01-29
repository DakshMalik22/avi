package set2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class ques1 {
    public static void main(String[] args) {
        Map<Character,Integer> m = new HashMap<>();
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        for(char c: input.toCharArray())
         {
             m.put(c,m.getOrDefault(c,0)+1);
         }

       for(char c: m.keySet())
       {
           if(m.get(c)==1)
           {
               System.out.println(c);
           }
       }


    }



}
