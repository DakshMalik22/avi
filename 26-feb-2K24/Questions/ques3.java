package Questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ques3 {
    public int isScramble(final String A, final String B) {
        if (A.length() != B.length() || !isAnagram(A, B)) {
            return 0;
        }

        if (A.equals(B)) {
            return 1;
        }

        Map<String, Integer> memo = new HashMap<>();
        return isScrambleHelper(A, B, memo);
    }

    private int isScrambleHelper(String A, String B, Map<String, Integer> memo) {
        if (A.equals(B)) {
            return 1;
        }

        if (A.length() <= 1) {
            return 0;
        }

        String key = A + "-" + B;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int n = A.length();
        for (int i = 1; i < n; i++) {
            if ((isScrambleHelper(A.substring(0, i), B.substring(0, i), memo) == 1 &&
                    isScrambleHelper(A.substring(i), B.substring(i), memo) == 1) ||
                    (isScrambleHelper(A.substring(0, i), B.substring(n - i), memo) == 1 &&
                            isScrambleHelper(A.substring(i), B.substring(0, n - i), memo) == 1)) {
                memo.put(key, 1);
                return 1;
            }
        }

        memo.put(key, 0);
        return 0;
    }

    private boolean isAnagram(String A, String B) {
        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();
        Arrays.sort(charsA);
        Arrays.sort(charsB);
        return Arrays.equals(charsA, charsB);
    }
    public static void main(String[] args) {
        ques3 solution = new ques3();

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String 1 : ");
        String string1= sc.next();
        System.out.println("Enter String 2 : ");
        String string2= sc.next();
        System.out.println(solution.isScramble(string1,string2));
    }
}
