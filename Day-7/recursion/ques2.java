package Day_7.recursion;

import java.util.Scanner;

public class ques2 {
    public static void find(int n,int count) {

        if(n==0)
        {
            System.out.println(count);
            return;
        }

        count++;

        find(n/10,count);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count=0;
        find(n,count);

    }
}
