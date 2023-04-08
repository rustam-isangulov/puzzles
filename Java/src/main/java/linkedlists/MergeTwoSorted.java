package linkedlists;

/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
 */

public class MergeTwoSorted {
	public ListNode mergeTwoLists( ListNode list1, ListNode list2 ) {
		ListNode result = null;

		if (list2 != null && list1 != null) {
			if (list1.val >= list2.val) {
				list2.next = mergeTwoLists(list1, list2.next);
				result = list2;
			} else {
				list1.next = mergeTwoLists(list1.next, list2);
				result = list1;
			}
		}

		if (list1 == null && list2 != null) {
			return list2;
		}
		if (list1 != null && list2 == null) {
			return list1;
		}

		return result;
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
    }
}
