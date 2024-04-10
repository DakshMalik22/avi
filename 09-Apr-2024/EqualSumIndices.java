package com.example;

import java.util.ArrayList;
import java.util.HashSet;

public class EqualSumIndices {

    public static ArrayList<Integer> findIndicesWithEqualSum(ArrayList<Integer> numbers) {
        int length = numbers.size();
        ArrayList<Integer> result = new ArrayList<>(4);
        HashSet<Integer> numberSet = new HashSet<>(numbers);

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = i + 1; k < length - 1; k++) {
                    if (j == k)
                        continue;
                    int x = numbers.get(i) + numbers.get(j) - numbers.get(k);
                    if (numberSet.contains(x)) {
                        for (int m = k + 1; m < length; m++) {
                            if (numbers.get(m) == x && m != j) {
                                result.add(i);
                                result.add(j);
                                result.add(k);
                                result.add(m);
                                return result;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 7, 1, 2, 9, 8};
        ArrayList<Integer> input = new ArrayList<>();
        for (int i : arr) {
            input.add(i);
        }
        ArrayList<Integer> result = findIndicesWithEqualSum(input);
        System.out.println("Indices with equal sum: " + result);
    }
}
