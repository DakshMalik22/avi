class ListNode {
    public int value;
    public ListNode next;
    
    ListNode(int val) {
        value = val;
        next = null;
    }
}

public class PalindromeLinkedListChecker {
    public int isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode prev = null;
        ListNode curr = slow;
        ListNode next;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        ListNode firstHalf = head;
        ListNode secondHalf = prev;
        
        while (secondHalf != null) {
            if (firstHalf.value != secondHalf.value) {
                return 0;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        return 1;
    }
}
