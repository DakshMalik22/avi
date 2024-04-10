package com.example;

class NumberGenerator {

    public static void generateSteppingNumbersInRange(int start, int end) {
        for (int i = 0; i <= 9; i++)
            dfs(start, end, i);
    }

    public static void dfs(int lowerBound, int upperBound, int currentNumber) {
        if (currentNumber <= upperBound && currentNumber >= lowerBound)
            System.out.print(currentNumber + " ");

        if (currentNumber == 0 || currentNumber > upperBound)
            return;

        int lastDigit = currentNumber % 10;

        int nextStep1 = currentNumber * 10 + (lastDigit - 1);
        int nextStep2 = currentNumber * 10 + (lastDigit + 1);

        if (lastDigit == 0)
            dfs(lowerBound, upperBound, nextStep2);
        else if (lastDigit == 9)
            dfs(lowerBound, upperBound, nextStep1);
        else {
            dfs(lowerBound, upperBound, nextStep1);
            dfs(lowerBound, upperBound, nextStep2);
        }
    }

    public static void main(String args[]) {
        int lowerRange = 10, upperRange = 20;
        generateSteppingNumbersInRange(lowerRange, upperRange);
    }
}
