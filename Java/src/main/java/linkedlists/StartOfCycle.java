package linkedlists;

import java.util.*;

/**
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * NOTE: there are some cool solutions with moving through potential cycles with different speed
 * and therefore avoiding infinity loop... verry cool :)
 */

public class StartOfCycle {
    public ListNode startOfCycleNode( ListNode head ) {
        // iteration #1
        ListNode cycle_start = null;

        if (head == null) return head;

        var set = new HashSet<ListNode>();
        set.add(head);

        while ((head = head.next) != null) {
            if (set.contains(head)) {
                cycle_start = head;
                break;
            } else {
                set.add(head);
            }
        }

        return cycle_start;
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
            return Integer.toString(val);
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
