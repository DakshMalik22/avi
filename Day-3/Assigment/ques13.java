package Assigment;

import java.util.Scanner;

public class ques13 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7};
        int size = arr.length;

        Scanner use = new Scanner(System.in);
        int m = use.nextInt();
        int ans= arr.length;

        int start=0;
        int end = arr.length-1;
        while(start<=end)
        {
            int mid =  start+(end-start)/2;

            if(arr[mid]==m)
            {
                ans=mid;
                break;

            }
            if(arr[mid]>=m)
            {
                ans = mid;
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }

        }
        System.out.println(ans);
    }
}
