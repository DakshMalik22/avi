package Day_5;

import java.util.Scanner;

public class ques5 {
    static int ans(int n,int b ,int c)
    {
        if(b<0 || c<0)
        {
            return 0;
        }
        if(n==0)
        {
            return 1;
        }

        int result = ans(n-1,b,c);
        result+=ans(n-1,b-1,c);
        result +=ans(n-1,b,c-1);

        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println( ans(n,1,2));


    }
}
