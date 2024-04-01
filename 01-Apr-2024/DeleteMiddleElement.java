package javaBasics.date_01_04_24;

import java.util.*;

public class DeleteMiddleElement {
    public static void main(String[] args) {
        Stack<Integer> arr = new Stack<>();
        arr.push(1);
        arr.push(2);
        arr.push(3);
        arr.push(4);
        arr.push(5);

        int N = arr.size() / 2 + 1;

        deleteMiddleElement(arr, N);

        System.out.println("Resulting stack after deleting middlemost element:");
        System.out.println(arr);
    }

    static void deleteMiddleElement(Stack<Integer> arr, int N) {
        if (arr.size() == N * 2 - 1) {
            Stack<Integer> tempStack = new Stack<>();
            int middleIndex = arr.size() / 2 + 1;
            for (int i = 0; i < middleIndex; i++) {
                tempStack.push(arr.pop());
            }
            arr.pop();
            while (!tempStack.isEmpty()) {
                arr.push(tempStack.pop());
            }
        }
    }
}
