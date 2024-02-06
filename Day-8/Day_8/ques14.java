package Day_8;

import java.util.Stack;

public class ques14 {
    // Recursive function to sort a stack
    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty() || stack.size() == 1) {
            return; // Base case: stack is already sorted
        }

        // Pop the top element from the stack
        int temp = stack.pop();

        // Recursively sort the remaining elements of the stack
        sortStack(stack);

        // Insert the popped element back into the stack in the correct position
        insert(stack, temp);
    }

    // Recursive function to insert an element into a sorted stack
    private static void insert(Stack<Integer> stack, int value) {
        // Base case: if the stack is empty or the top element is smaller than value, push value onto the stack
        if (stack.isEmpty() || stack.peek() < value) {
            stack.push(value);
            return;
        }

        // Pop elements from the stack until finding the correct position to insert value
        int temp = stack.pop();
        insert(stack, value);

        // Push the popped element back onto the stack after inserting value
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(-3);
        s1.push(14);
        s1.push(18);
        s1.push(-5);
        s1.push(30);

        System.out.println("Input: " + s1);
        sortStack(s1);
        System.out.println("Output: " + s1);

        Stack<Integer> s2 = new Stack<>();
        s2.push(1);
        s2.push(2);
        s2.push(3);

        System.out.println("Input: " + s2);
        sortStack(s2);
        System.out.println("Output: " + s2);
    }
}
