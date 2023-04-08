package linkedlists;

/*
Given the head of a singly linked list, return true if it is a palindrome.
 */

public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
		// solution 1:
		// reverse head list into headRev
		// compare head and headRev element by element

		// solution 2:
		// head : e -> e -> e -> e
		//        r <- r <- r <- r
		// traverse to the end of the list to get the first r
		// then compare it to the head's e
		// move head -> next, and r -> prev
		// when e.val and r.val are not equal -> return null
		// and therefore collapse the search

		// solution 2:
		return compareHeadTail(head, head.next) != null;
	}

	static ListNode compareHeadTail( ListNode head, ListNode tail ) {
		// comparing head to head - always good
		if (null == tail) return head;

		// we have reached the end of the list
		// compare the last node with the head
		if (null == tail.next) {
			if (head.val == tail.val) {
				return head.next;
			}
			return null;
		}

		// not the end yet
		// send the recursion down the list
		// get an updated "current head to compare"
		head = compareHeadTail(head, tail.next);
		// and do the comparison
		if (null != head) {
			if (head.val == tail.val) {
				return head.next;
			}
		}

		return null;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {}

		ListNode(int val) { this.val = val; }

		ListNode(int val, ListNode next) { this.val = val; this.next = next; }

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
