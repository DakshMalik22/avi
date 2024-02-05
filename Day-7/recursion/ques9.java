package Day_7.recursion;

import java.util.Scanner;

public class ques9 {
    public static void ans(int[] arr,int x,int i,int index) {
      if(arr.length<=i)
      {
          System.out.println(index);
          return;
      }

      if(x==arr[i])
      {
          index = i;
      }
      ans(arr,x,i+1,index);
    }
    public static void main(String[] args) {
        int[]arr = {9 ,8 ,10 ,8};

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int index=-1;
        ans(arr,x,0,index);
    }
}
