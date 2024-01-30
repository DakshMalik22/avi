package Assigment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ques1 {
    public static void main(String[] args) {
        int[] arr = {4,2,8,5,3};
        List<List<Integer>>myList = new ArrayList<>();
        Arrays.sort(arr);
        int s=10;
        for(int i=0;i<arr.length-2;i++)
        {
            if(i>0 && arr[i]==arr[i-1])
            {
                continue;
            }

            int j=i+1;
            int k=arr.length-1;
            while(j<=k)
            {
                int sum = arr[i]+arr[j]+arr[k];
                 if(sum<s)
                 {
                     j++;
                 } else if (sum>s) {
                     k--;
                 }
                 else
                 {
                     myList.add(Arrays.asList(arr[i],arr[k],arr[j]));
                     k--;
                     j++;
                 }
            }

        }
        for(List<Integer> list:myList){
            System.out.println(list);
        }

    }
}
