package LinkedListOperations;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }
}

public class SumLinkedLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfList1 = getUserInput(scanner, "Enter size of the first list:");
        ListNode head1 = createList(scanner, sizeOfList1, "Enter elements of the first list:");

        int sizeOfList2 = getUserInput(scanner, "Enter size of the second list:");
        ListNode head2 = createList(scanner, sizeOfList2, "Enter elements of the second list:");

        ListNode reversedList1 = reverseList(head1.next);
        ListNode reversedList2 = reverseList(head2.next);

        ListNode reversedAddedList = addLists(reversedList1, reversedList2);

        ListNode finalAddedList = reverseList(reversedAddedList);
        System.out.println("Result list:");
        printList(finalAddedList);
    }

    public static int getUserInput(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

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

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static ListNode addLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode current = result;
        int carry = 0;

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
            current.next = new ListNode(sum % 10);
            carry = sum / 10;
            current = current.next;
        }
        return result.next;
    }
}
