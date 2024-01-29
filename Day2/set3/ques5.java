package set3;

import java.util.Scanner;

public class ques5 {
    public static void main(String[] args) {
        Scanner query= new Scanner(System.in);
        int q = query.nextInt();
        int sum=0;
        int multi =1;
        if(q==1)
        {
            for(int i =1;i<=4;i++)
            {
                sum+=i;
            }
            System.out.println(sum);

        }
        else
        {
            for(int i =1;i<=4;i++)
            {
                multi*=i;
            }
            System.out.println(multi);

        }

    }
}
