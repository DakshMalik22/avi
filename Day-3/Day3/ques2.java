package Day3;

import java.util.Scanner;

public class ques2 {
    public static void main(String[] args) {
        Scanner find = new Scanner(System.in);
        int x = find.nextInt();
        int size = find.nextInt();
        int[] arr = new int[size];

        for(int i=0;i<size;i++)
        {
            arr[i] = find.nextInt();
        }
        int first =-1;
        int start =0;
        int end = size-1;
        while(start<=end)
        {
            int mid = start+(end-start)/2;
            if(arr[mid]==x)
            {
                first = mid;
                end = mid-1;
            } else if (arr[mid] > x) {
               end = mid-1;
            }
            else
            {
               start=mid+1;
            }
        }
         int last = -1;
         start =0;
         end = size-1;
        while(start<=end)
        {
            int mid = start+(end-start)/2;
            if(arr[mid]==x)
            {
                last= mid;
                start = mid+1;
            } else if (arr[mid] > x) {
                end=mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        System.out.print(first+" "+last);
    }
}
