package Day_7.recursion;

import java.util.Scanner;

public class ques3 {
    public static void ans(int[] arr,int sum,int i) {
        if(i==arr.length)
        {
            System.out.println(sum);
            return;
        }

        sum+=arr[i];
        ans(arr,sum,i+1);
    }
    public static void main(String[] args) {
        int[]arr = new int[3];
        Scanner sc = new Scanner(System.in);


        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element at index " + i + ": ");
            arr[i] = sc.nextInt();
        }

        int sum=0;
        int i=0;

        ans(arr,sum,i);

    }
}
