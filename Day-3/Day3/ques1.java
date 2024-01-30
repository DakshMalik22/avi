package Day3;

import java.util.Scanner;

public class ques1 {
    public static void main(String[] args) {
        Scanner find = new Scanner(System.in);
        int x = find.nextInt();
        int size = find.nextInt();

        int[] arr = new int[size];

        for(int i=0;i<size;i++)
        {
            arr[i] = find.nextInt();
        }

        int count=0;
        for (int i=0;i<size;i++)
        {
            if(arr[i]==x)
            {
                count++;
            }
        }
        System.out.println(count);
    }
}
