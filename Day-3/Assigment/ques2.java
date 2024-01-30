package Assigment;

import java.util.ArrayList;
import java.util.HashSet;

public class ques2 {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,3};
        int i=0;

        for(int j=1;j<arr.length;j++)
        {
            if(arr[i]!=arr[j])
            {
                i++;
                arr[i]=arr[j];
            }
        }
        System.out.println(i+1);
    }
}
