

import java.util.ArrayList;
import java.util.Scanner;

public class WindowAvg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Prompting the user to input the size of the number
        System.out.print("Enter the size of the number: ");
        int n = sc.nextInt();

        // ArrayList to store the digits of the number
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // Prompting the user to input each digit of the number
            System.out.print("Enter digit "+(i+1)+": ");
            int digit = sc.nextInt();
            list.add(digit);
        }

        int window_size;
        // Loop to ensure valid window size input
        do {
            System.out.print("Enter the window size: ");
            window_size = sc.nextInt();
        }
        while (window_size<1 || window_size>n);

        int start = 0;
        int end = window_size-1;
        ArrayList<Integer> result = new ArrayList<>();

        // Sliding window approach to calculate the average of each window
        while(end<n){
            double sum = 0;
            for(int i=start; i<=end; i++){
                sum+= list.get(i);
            }
            // Calculating the average of the current window
            int ans = (int)Math.ceil(sum/window_size);
            result.add(ans);
            start++;
            end++;
        }

        // Printing the result (average of each window)
        System.out.println(result);
    }
}
