package Day_8;

import java.util.Scanner;

public class ques7 {
    static int ans(int x,int y,int ans1)
    {
        if(y==0)
        {
            return 0;
        }
        if(y==1)
        {
            return ans1;

        }
      return  ans(x,y-1,ans1+x);

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int ans1=0;
        System.out.println(ans(x,y+1,ans1));
    }
}
