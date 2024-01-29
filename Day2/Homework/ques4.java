package Homework;

import java.util.Scanner;

public class ques4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        printPattern2(N);
    }

    static void printPattern2(int N) {
        for (int i = 1; i <= N / 2 + 1; i++) {
            for (int j = N / 2 + 1; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = N / 2; i >= 1; i--) {
            for (int j = N / 2 + 1; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
