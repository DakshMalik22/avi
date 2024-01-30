package Assigment;

import java.util.HashSet;

public class ques9 {
    public static void main(String[] args) {
        int[] arr = {1, 9, 3, 10, 4, 20, 2};
        int N = arr.length;
        HashSet<Integer>mp = new HashSet<>();

        for(int i=0;i<N;i++)
        {
            mp.add(arr[i]);
        }

        int ans =0;
        for(int i:mp)
        {
            if(!mp.contains(i-1))
            {
                int count =1;
                int x = i ;
                while(mp.contains(x+1))
                {
                    count++;
                    x = x+1;

                }
                ans  = Math.max(ans,count);
            }
        }
        System.out.println(ans);
    }
}
