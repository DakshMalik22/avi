package java_Learning;

import java.util.Scanner;

public class subtraction {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int x= input.nextInt();

        for(int i=0 ; i<x;i++)
        {
            for (int j = x; j>0; j--)
            {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}


/*
4321
4321
4321
4321

1
12
123
1234


4444
333
22
1


1
23
456
7890

 */