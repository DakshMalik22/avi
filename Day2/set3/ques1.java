package set3;

import java.util.ArrayList;
import java.util.Scanner;

public class ques1 {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();

        Scanner use = new Scanner(System.in);
        int n = use.nextInt();
        for(int i=0;i<n;i++)
        {
            myList.add(use.nextInt());
        }
        int sum =0;
        for(int s:myList)
        {
            sum+=s;
        }
        System.out.println(sum);
    }
}
