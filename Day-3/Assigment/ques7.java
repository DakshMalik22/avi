package Assigment;

import java.util.PriorityQueue;
import java.util.Scanner;

public class ques7 {
    public static void main(String[] args) {
        PriorityQueue<Integer>maxHeap = new PriorityQueue<>((a,b)->b-a);
        int j = 0;
        Scanner find = new Scanner(System.in);
        int k = 2;

        int n=4;
        int[] arr = {3 ,4, 2 ,1};

        for (int num : arr) {
            maxHeap.offer(num);
        }

        int[] result = new int[k];
        for (int i = k-1; i >=0; i--) {
            result[i] = maxHeap.poll();
        }
for (int i=0;i<k;i++)
{
    System.out.print(result[i]+" ");
}

    }
}
