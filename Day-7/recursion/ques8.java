package Day_7.recursion;

import java.util.Scanner;

public class ques8 {
    public static void toh(int n,char t1,char t2,char t3){
      if(n==0)
      {
          return;
      }
      toh(n-1,t1,t3,t2);
        System.out.println(n + " " + t1 +" -> " +t2);
        toh(n-1,t3,t2,t1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        char t1 = sc.next().charAt(0);
        char t2 = sc.next().charAt(0);
        char t3 = sc.next().charAt(0);

        toh(n,t1,t2,t3);
    }
}
