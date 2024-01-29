package Assigment;

import java.util.ArrayList;
import java.util.Scanner;

public class ques5 {
    public static void main(String[] args) {
        Scanner find = new Scanner(System.in);
        int r = find.nextInt();
        int l = find.nextInt();
        int[]arr = {1,2,3};
        int sum=0;



        for(int i=l;i<=r;i++)
        {
            int ind = (i-1)% arr.length;
           sum= sum + arr[ind];

        }
        System.out.print(sum+" ");
    }
}
