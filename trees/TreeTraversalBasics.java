package trees;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;

import java.util.stream.Stream;
import java.util.stream.Collectors;

/*
 binary tree traversal - basic methods
*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
	this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
	this.val = val;
	this.left = left;
	this.right = right;
    }
}

public class TreeTraversalBasics {
    public static void main(String... args) {
	System.out.println();
	System.out.println("TreeTraversalBasics is starting...");
	System.out.println();

	test(new Integer[]{1,2,2,3,3,null,null,4,4});
	System.out.println();

	test(new Integer[]{5, 1, 4, null, null, 3, 6});
	System.out.println();

	test(new Integer[]{5, 3, 7, null, 4, 6});
	System.out.println();

	test(new Integer[]{1, 2, 3, 4, 5});
	System.out.println();

	test(new Integer[]{1, 2});
	System.out.println();

	test(new Integer[] {1, 2, 3, null, 4, 5, 6});
	System.out.println();

	System.out.println();
	System.out.println("TreeTraversalBasics has finsihed.");
    }


    public static void test(Integer[] values) {
	System.out.print("Input: ");
	System.out.println(Arrays.toString(values));

	System.out.println("Deserialised tree:");

	var tree = deserialiseTree(values);
	printTree(tree);

	System.out.println("Traverse Left Edge:");
	traverseLeftEdge(tree);

	System.out.println();

	System.out.println("Traverse Right Edge:");
	traverseRightEdge(tree);

	System.out.println();

	System.out.println("Traverse Clockwise (bottom left to root to bottom right)");
	traverseClockwise(tree);

	System.out.println();
    }


    public static void traverseLeftEdge(TreeNode root) {
	if (null == root) return;

	System.out.print(root.val + ((null != root.left) ? " -> " : ""));
	traverseLeftEdge(root.left);
    }


    public static void traverseLeftEdgePost(TreeNode root) {
	if (null == root) return;

	traverseLeftEdgePost(root.left);
	System.out.print(((null != root.left) ? " -> " : "") + root.val);
    }


    public static void traverseRightEdge(TreeNode root) {
	if (null == root) return;

	System.out.print(root.val + ((null != root.right) ? " -> " : ""));
	traverseRightEdge(root.right);
    }


    public static void traverseClockwise(TreeNode root) {
	if (null == root) return;

	traverseLeftEdgePost(root);
	System.out.print((null != root.right) ? " -> " : "");
	traverseRightEdge(root.right);
    }


    //
    // convert leetcode style
    // array tree representaiton
    // into an actual tree structure
    // [1, 2, 3, null, 4, 5, 6]
    // turns into
    //         1
    //     2      3
    // null  4  5  6
    //
    public static TreeNode deserialiseTree(Integer[] values) {
	// basic check
	if (values.length == 0) return null;

	// structure to hold all parent nodes
	// whose descendants are need to be filled
	Queue<TreeNode> parents = new ArrayDeque<>();

	// set the root
	TreeNode root = new TreeNode(values[0]);
	// we have a new parent, add to the list
	parents.offer(root);

	// we are starting to populate
	// with the left descendant
	boolean left = true;

	for (int index = 1; index < values.length; index++) {
	    TreeNode newDescendant
		= (values[index] != null) ? new TreeNode(values[index]) : null;

	    if (left) {
		// if we need to add the left descendant
		// we need to leave its parent in the queue
		// so that the right descendant can be added
		parents.peek().left = newDescendant;

	    } else {
		// if we are filling in the right descendant
		// this parent should no longer be int the queu
		parents.poll().right = newDescendant;
	    }

	    if (null != newDescendant) {
		parents.offer(newDescendant);
	    }

	    // flip the side
	    // for the next descendant
	    left = !left;
	}

	return root;
    }


    public static void printTree(TreeNode root) {
	// main idea is to collect parents node and print them
	// then use that collection of parents to collect all descendants
	// make descendants "the new" parents ... and repeat.. simpls.
	List<TreeNode> parents = new ArrayList<>();

	// set the root node
	parents.add(root);
	// print level by level
	printTreeLevels(parents);
    }


    static void printTreeLevels(List<TreeNode> level) {
        boolean hasNonNulls = false;
	List<TreeNode> descendants = new ArrayList<>();

	for (var node : level) {
	    System.out.print
		(((null != node) ? node.val : "null") + " ");

	    if (null != node) {
		descendants.add(node.left);
		descendants.add(node.right);

		if (!hasNonNulls && (null != node.left || null != node.right)) {
		    hasNonNulls = true;
		}
	    }
	}

	// line breaker
	System.out.println();

	if (hasNonNulls) {
	    // print the next level down
	    printTreeLevels(descendants);
	}
    }
}
