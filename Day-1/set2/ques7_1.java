package set2;

import java.util.ArrayList;

public class ques7_1 {
    public static void main(String[] args) {
        int n=4;

       for(int i=0;i<n;i++)
       {
           char ch = (char)('A'+i);
           for(int j=0;j<=i;j++)
           {
               System.out.print(ch);
               ch++;
           }
           System.out.println();
       }

    }
}
