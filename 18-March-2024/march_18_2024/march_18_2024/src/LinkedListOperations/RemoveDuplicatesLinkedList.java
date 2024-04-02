import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class ListNode {
    int data; // Represents the data stored in the node
    ListNode nextNode; // Reference to the next node in the linked list

    ListNode() {
    }

    ListNode(int data) {
        this.data = data;
    }
}

public class RemoveDuplicatesLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of the linked list:");
        int sizeOfList = scanner.nextInt();
        
        // Creating a dummy node to hold the head of the linked list
        ListNode head = new ListNode();
        ListNode current = head; // Pointer to traverse the linked list
        
        // Input elements into the linked list
        System.out.println("Enter " + sizeOfList + " elements of the linked list:");
        for (int i = 0; i < sizeOfList; i++) {
            current.nextNode = new ListNode(scanner.nextInt());
            current = current.nextNode; // Move the pointer to the newly added node
        }
        
        // Call the function to remove duplicates from the linked list
        ListNode resultList = removeDuplicates(head.nextNode);
        
        // Print the resulting linked list after removing duplicates
        System.out.println("Result list:");
        while (resultList != null) {
            System.out.println(resultList.data);
            resultList = resultList.nextNode;
        }
    }

    // Function to remove duplicates from a linked list
    public static ListNode removeDuplicates(ListNode head) {
        Set<Integer> seenValues = new HashSet<>(); // Set to keep track of seen values
        ListNode resultHead = new ListNode(); // Dummy node for the resulting linked list
        ListNode currentResult = resultHead; // Pointer to traverse the resulting linked list
        
        // Traverse the original linked list
        while (head != null) {
            // If the value is not seen before, add it to the resulting linked list
            if (!seenValues.contains(head.data)) {
                currentResult.nextNode = new ListNode(head.data);
                currentResult = currentResult.nextNode; // Move the pointer
                seenValues.add(head.data); // Add the value to the set of seen values
            }
            head = head.nextNode; // Move to the next node in the original linked list
        }
        return resultHead.nextNode; // Return the head of the resulting linked list
    }
}

