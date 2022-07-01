package linkedlists;

/**
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.
 */

public class MiddleOfList {
    public static void main(String... args) {
	System.out.println("Middle of List is starting...");

	Test(null);
	Test(new ListNode(1, new ListNode(3, new ListNode(4))));
	Test(new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(5)))));
    }


    static ListNode middleNode(ListNode head) {
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


    static void Test(ListNode head) {
	System.out.println();
	System.out.println
	    ("Input list1: ["
	     + (head!=null ? head.toString(): "")
	     + "]");
	ListNode result = middleNode(head);
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
