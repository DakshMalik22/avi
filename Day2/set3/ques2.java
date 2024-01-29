package set3;

import java.util.Scanner;

public class ques2 {

    public static void reverse(int[] arr,int start,int end) {
        while(start<=end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

    }
    public static void main(String[] args) {
        Scanner find = new Scanner(System.in);
       int m = find.nextInt();
        int[] arr = {1,2,3,4,5,6};
        reverse(arr,m+1,arr.length-1);
        for (int s:arr)
        {
            System.out.print(s);
        }

    }
}
