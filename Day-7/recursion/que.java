package Day_7.recursion;

import java.util.Arrays;

public class que {
    public static void reverse(int[]arr,int i,int j)
    {
       if(i>j)
       {
           System.out.println(Arrays.toString(arr));
           return;
       }

       int temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;
       reverse(arr,++i,--j);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        int i=0;
        int j= arr.length-1;
        reverse(arr,i,j);

    }
}
