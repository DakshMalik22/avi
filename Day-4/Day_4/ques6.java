package Day_4;

import java.util.ArrayList;

public class ques6 {
    public static void main(String[] args) {
        String find = "aabccbaa";
        int x = 'b';
        ArrayList<Character>myList = new ArrayList<Character>();

        int i=0;
        int j=1;


        for (int k=0;k<find.length();k++)
        {
            if(find.charAt(k)!=x)
            {
                myList.add(find.charAt(k));

            }
            else {
                continue;
            }

        }
        for(int f=0;f<find.length();f++)
        {
            System.out.println(myList.get(f));
        }


    }
}
