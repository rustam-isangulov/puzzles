package linkedlists;

/*
Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

public class ReverseList {
    public static void main(String... args) {
	System.out.println("Reverse list is starting...");

	Test(null);
	Test(new ListNode(1, new ListNode(3, new ListNode(4))));
	Test(new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(5)))));
    }


    static ListNode reverseList(ListNode head) {
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


    static void Test(ListNode head) {
	System.out.println();
	System.out.println
	    ("Input list1: ["
	     + (head!=null ? head.toString(): "")
	     + "]");
	ListNode result = reverseList(head);
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
