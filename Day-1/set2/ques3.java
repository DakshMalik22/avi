package set2;

import java.util.Scanner;

public class ques3 {
    public static void main(String[] args) {
      int even= 0;
      int odd = 0;

        Scanner inp = new Scanner(System.in);

        int digits = inp.nextInt();

        while(digits>0)
        {
            int v = digits%10;
            digits = digits/10;

            if(v%2==0)
            {
                even+=v;
            }
            else
            {
                odd+=v;
            }
        }
        System.out.println(even+""+odd);

    }
}
