import java.util.LinkedList;
import java.util.Queue;

public class ques11 {
    // Recursive function to reverse the queue
    static void ans(Queue<Integer> queue, int i, int size) {
        // Base case: If we have reached the end of the queue, return
        if (i == size - 1) {
            return;
        }

        // Remove the front element of the queue
        int store = queue.poll();

        // Recursively reverse the remaining queue
        ans(queue, i + 1, size);

        // Add the removed element back to the queue at the end
        queue.add(store);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // Add elements to the queue
        queue.add(1);
        queue.add(2);
        queue.add(3);

        // Initial index and size of the queue
        int i = 0;
        int size = queue.size();

        // Call the recursive function to reverse the queue
        ans(queue, i, size);

        // Print the reversed queue
        System.out.println("Reversed Queue:");
        for (Integer element : queue) {
            System.out.print(element + " ");
        }
    }
}
