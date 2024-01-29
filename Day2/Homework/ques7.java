package Homework;

import java.util.Scanner;

public class ques7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        printPattern3(N);
    }

    static void printPattern3(int N) {
        for (int i = N; i >= 1; i--) {
            for (int j = N; j >= 1; j--) {
                if (j == i) {
                    System.out.print("*");
                } else {
                    System.out.print(j);
                }
            }
            System.out.println();
        }
    }
}
