package Homework;

public class ques6 {
    public static void main(String[] args) {
        int n = 51415;
        System.out.println(isPalindrome(n));
    }

    static boolean isPalindrome(int n) {
        int reversed = 0;
        int original = n;

        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }

        return original == reversed;
    }
}
