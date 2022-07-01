package linkedlists;

import java.util.*;

/**
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

NOTE: there are some cool solutions with moving through potential cycles with different speed
and therofore avoiding infinity loop... verry cool :)
 */

public class StartOfCycle {
    public static void main(String... args) {
	System.out.println("Start of Cycle is starting...");


	ListNode start = new ListNode(16);
	ListNode[]  nodes =  new ListNode[]{new ListNode(0), new ListNode(1), new ListNode(2), new ListNode(3), new ListNode(-4)};

	ListNode list1 = start;
	start.next = nodes[1];
	nodes[1].next = nodes[2];
	nodes[2].next = nodes[3];
	nodes[3].next = nodes[4];
	nodes[4].next = nodes[2];

	Test(null);
	Test(list1);
	Test(new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(5)))));
    }


    static ListNode middleNode(ListNode head) {
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
	    return Integer.toString(val);
	}
    }
}
