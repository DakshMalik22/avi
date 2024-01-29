package Homework;

import java.util.Scanner;

public class ques5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        triangleOfSums(N);
    }

    static void triangleOfSums(int N) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += i;
            for (int j = 1; j <= i; j++) {
                System.out.print(j);

                if (j < i) {
                    System.out.print("+");
                }
            }
            System.out.println("=" + sum);
        }
    }
}
