package Homework;

import java.util.Scanner;

public class ques2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        printPrimes(N);
    }

    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static void printPrimes(int N) {
        for (int i = 2; i <= N; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }
}
