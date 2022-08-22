package linkedlists;

import java.util.Arrays;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/*
Given the head of a singly linked list, return true if it is a palindrome.
 */

public class PalindromeLinkedList {
    public static void main(String... args) {
	System.out.println("Palindome linked lists starting...");

	test(new int[] {-1});
	test(new int[] {0, 0});
	test(new int[]{1, 2, 2, 1});
	test(new int[]{-1,0});
	test(new int[]{1, 2, 3, 4, 2, 1});

	System.out.println("PalindromeLinkedList has finihed.");
    }


    public static void test(int[] values) {
	System.out.println();

	System.out.println("Input: " + Arrays.toString(values));

	var head =  deserialiseList(values);

	printList(head);

	System.out.println();

	System.out.println("Output: " + isPalindrome(head));

	System.out.println();
    }


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
	// and therfore collapse the search

	// solution 2:
	if (compareHeadTail(head, head.next) == null ) {
	    return false;
	} else {
	    return true;
	}
    }

    static ListNode compareHeadTail( ListNode head, ListNode tail ) {
	// comparing head to head - always good
	if (null == tail) return head;

	// we have reached the end of the list
	// compare the last node with the head
	if (null == tail.next) {
	    if (head.val == tail.val) {
		return head.next;
	    } else {
		return null;
	    }
	} else {
	    // not the end yet
	    // send the recursion down the list
	    // get an updated "current head to compare"
	    head = compareHeadTail(head, tail.next);
	    // and do the comparision
	    if (null != head) {
		if (head.val == tail.val) {
		    return head.next;
		} else {
		    return null;
		}
	    } else {
		return null;
	    }
	}
    }


    static ListNode deserialiseList(int[] values) {
	// basic check
	if (values == null && values.length == 0) return null;

	ListNode head = new ListNode(values[0]);

	ListNode current = head;

	for (int i = 1; i < values.length; i++) {
	    current.next = new ListNode(values[i]);
	    current = current.next;
	}

	return head;
    }

    static void printList(ListNode head) {
	while (head != null) {
	    System.out.print(head.val + ((null != head.next ) ? " -> " : ""));
	    head = head.next;
	}
    }
}
