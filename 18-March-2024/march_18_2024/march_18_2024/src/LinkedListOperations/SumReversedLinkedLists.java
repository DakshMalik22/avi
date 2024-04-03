import java.util.Scanner;

class SumReversedLinkedLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get size and elements of the first list
        int sizeOfList1 = getUserInput(scanner, "Enter size of the first list:");
        ListNode head1 = createList(scanner, sizeOfList1, "Enter elements of the first list:");

        // Get size and elements of the second list
        int sizeOfList2 = getUserInput(scanner, "Enter size of the second list:");
        ListNode head2 = createList(scanner, sizeOfList2, "Enter elements of the second list:");

        // Add the reversed lists and print the result
        ListNode resultList = addReversedLists(head1.next, head2.next);
        System.out.println("Result:");
        printList(resultList);
    }

  
    public static int getUserInput(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    // Function to create a linked list
    public static ListNode createList(Scanner scanner, int size, String message) {
        System.out.println(message);
        ListNode head = new ListNode();
        ListNode list = head;
        for (int i = 0; i < size; i++) {
            list.next = new ListNode(scanner.nextInt());
            list = list.next;
        }
        return head;
    }

    // Function to print elements of a linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }

    // Function to add reversed linked lists
    public static ListNode addReversedLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode current = result;
        int carry = 0;

        // Iterate through both lists
        while (list1 != null || list2 != null || carry == 1) {
            int sum = carry;
            if (list1 != null) {
                sum += list1.val;
                list1 = list1.next;
            }
            if (list2 != null) {
                sum += list2.val;
                list2 = list2.next;
            }
            // Update result and carry
            current.next = new ListNode(sum % 10);
            carry = sum / 10;
            current = current.next;
        }
        return result.next;
    }
}
