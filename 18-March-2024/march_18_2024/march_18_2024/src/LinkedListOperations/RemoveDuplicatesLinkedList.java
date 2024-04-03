class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
//removing duplicates from linklist
public class RemoveDuplicatesLinkedList {
    public ListNode removeDuplicates(ListNode head) {
        if (head == null) return null;
        
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        
        return head;
    }
}
