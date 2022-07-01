package linkedlists;

/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
 */

public class MergeTwoSorted {
    public static void main(String... args) {
	System.out.println("Merge two sorted lists is starting...");

	Test(null, null);

	Test(null
	     , new ListNode(1, new ListNode(3, new ListNode(4))));

	Test(new ListNode(1, new ListNode(2, new ListNode(4)))
	     , new ListNode(1, new ListNode(3, new ListNode(4))));
    }


    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
	ListNode result = null;

	if (list1 == null && list2 != null) {
	    return list2;
	} else if (list1 != null && list2 == null) {
	    return list1;
	} else if (list2 != null && list1 != null ) {
	    if (list1.val >= list2.val) {
		list2.next = mergeTwoLists(list1, list2.next);
		result = list2;
	    } else {
		list1.next = mergeTwoLists(list1.next, list2);
		result = list1;
	    }
	}

	return result;
    }


    static void Test(ListNode list1, ListNode list2) {
	System.out.println();
	System.out.println
	    ("Input list1: ["
	     + (list1!=null ? list1.toString(): "")
	     + "] list2: ["
	     + (list2!=null ? list2.toString() : "") + "]") ;

	ListNode result = mergeTwoLists(list1, list2);
	System.out.println("Result: [" + (result!=null?result.toString():"") + "]");
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
