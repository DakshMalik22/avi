package set2;

import java.util.Scanner;

public class ques6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int ans =0;
        while(n!=0)
        {
            int digit = n%10;
            ans = ans*10+digit;
            n/=10;

        }
        System.out.println(ans);

    }
}
