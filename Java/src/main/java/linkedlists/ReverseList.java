package linkedlists;

/*
Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

public class ReverseList {
    public ListNode reverseList( ListNode head ) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode prev = null;
        ListNode next = head;

        while (next != null) {
            head = next;
            next = next.next;
            head.next = prev;
            prev = head;
        }

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode( int val ) {
            this.val = val;
        }

        ListNode( int val, ListNode next ) {
            this.val = val;
            this.next = next;
        }

        public String toString() {
            return val + (next != null ? ", " + next.toString() : "");
        }

        static ListNode deserializeList( int... values ) {
            if (values.length == 0) return null;

            ListNode head = new ListNode(values[0]);
            ListNode current = head;

            for (int i = 1; i < values.length; i++) {
                current.next = new ListNode(values[i]);
                current = current.next;
            }

            return head;
        }
    }
}
