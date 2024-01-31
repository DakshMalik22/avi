package Day_4;

import java.util.ArrayList;

public class ques5 {
    public static void main(String[] args) {
        String find = "aabbbcc";
        int i=0;
        int j=1;
        ArrayList<Character> myList  = new ArrayList<Character>();

        for (int k=0;k<find.length();k++)
        {
            if(myList.contains(find.charAt(k)))
            {
                continue;

            }
            else {
                myList.add(find.charAt(k));
            }

        }
        for(int f=0;f<find.length();f++)
        {
            System.out.println(myList.get(f));
        }

    }
}
