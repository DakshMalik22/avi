package Homework;

import java.util.Scanner;

public class ques3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        printPattern1(N);
    }

    static void printPattern1(int N) {
        for (int i = 1; i <= N; i++) {
            for (int j = N - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = i; j < 2 * i; j++) {
                System.out.print(j % 10);
            }
            for (int j = 2 * i - 2; j >= i; j--) {
                System.out.print(j % 10);
            }
            System.out.println();
        }
    }
}
