package java_Learning;

import java.util.Scanner;

public class Pattern2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();

        for(int i=1;i<=x;i++)
        {
            for(int j= 1 ;j<=i ; j++)
            {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
