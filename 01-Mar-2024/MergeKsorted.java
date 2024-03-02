import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        // Check if the input array is null or empty
        if (lists == null || lists.length == 0)
            throw new IllegalArgumentException("Input list array is null or empty");

        // Create a priority queue to store nodes based on their values
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head nodes of all lists to the priority queue
        for (ListNode node : lists) {
            if (node != null)
                pq.offer(node);
        }

        // Dummy node to simplify the code
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        try {
            // Keep merging until the priority queue is empty
            while (!pq.isEmpty()) {
                // Get the node with the smallest value from the priority queue
                ListNode minNode = pq.poll();
                // Add it to the merged list
                current.next = minNode;
                current = current.next;
                // Move to the next node in the list
                if (minNode.next != null)
                    pq.offer(minNode.next);
            }
        } catch (NullPointerException e) {
            // Handle NullPointerException (e.g., if a ListNode object is unexpectedly null)
            System.err.println("A null pointer was encountered: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            // Handle any other unexpected exceptions
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }

        // Return the merged list
        return dummy.next;
    }

    // Example usage
    public static void main(String[] args) {
        MergeKSortedLists solution = new MergeKSortedLists();

        // Example lists
        ListNode[] lists = new ListNode[3];
        lists[0] = createList(new int[] { 1, 10, 20 });
        lists[1] = createList(new int[] { 4, 11, 13 });
        lists[2] = createList(new int[] { 3, 8, 9 });

        try {
            // Merge the lists
            ListNode mergedList = solution.mergeKLists(lists);

            // Print the merged list
            printList(mergedList);
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Utility method to create a linked list from an array
    private static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Utility method to print a linked list
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
