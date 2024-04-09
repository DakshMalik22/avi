

import java.util.ArrayList;
import java.util.Collections;

public class MyFibonacciSum {
    public int findFibonacciSum(int number) {
        ArrayList<Long> fibonacciList = new ArrayList<>();
        fibonacciList.add(1L);
        fibonacciList.add(2L);
        long first = 1L;
        long second = 2L;
        
        while (true) {
            long current = first + second;
            if (current > 10000000000L)
                break;
            fibonacciList.add(current);
            first = second;
            second = current;
        }
        
        int answer = 0;
        long a = number;
        
        while (a > 0) {
            int index = Collections.binarySearch(fibonacciList, a);
            if (index >= 0) {
                answer++;
                return answer;
            } else {
                index = -(index + 1);
                index--;
                a = a - fibonacciList.get(index);
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        MyFibonacciSum solution = new MyFibonacciSum();
        int number = 7;
        int result = solution.findFibonacciSum(number);
        System.out.println(result);
    }
}
