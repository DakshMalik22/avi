package Day3;

import java.util.Scanner;

public class ques3 {
    public static void main(String[] args) {
        Scanner find = new Scanner(System.in);

        int size = find.nextInt();

        int[] arr = new int[size];

        for(int i=0;i<size;i++)
        {
            arr[i] = find.nextInt();
        }

        for (int i=0;i<size;i++)
        {
             int index= arr[i]%size;
             arr[index]+=size;
        }

        for(int i=0;i<size;i++)
        {
            if(arr[i]/size>=2)
            {
                System.out.println(i);
            }
        }
    }
}
