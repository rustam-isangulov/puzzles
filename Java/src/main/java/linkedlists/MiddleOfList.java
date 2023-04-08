package linkedlists;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 */

public class MiddleOfList {
    public ListNode middleNode( ListNode head ) {
        ListNode middle = head;
        boolean next_move = true;

        if (head == null) return head;

        while ((head = head.next) != null) {
            if (next_move) {
                middle = middle.next;
                next_move = false;
            } else {
                next_move = true;
            }
        }

        return middle;
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
    }
}
