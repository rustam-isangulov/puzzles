package trees;

import java.util.*;

/**
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */

public class ValidateBinarySearchTree {
    public static void main(String... args) {
	System.out.println("ValidateBinarySearchTree is starting...");

	System.out.println(">>>> expected: " + false);
	Test( new TreeNode(32
			   , new TreeNode(26
					  , new TreeNode(19
							 , null
							 , new TreeNode(27))
					  , null)
			   , new TreeNode(47
					  , null
					  , new TreeNode(56))));

	System.out.println(">>>> expected: " + false);
	Test( new TreeNode(-2147483648
			   , null
			   , new TreeNode(2147483647
					  , new TreeNode(-2147483648)
					  , null)));

	System.out.println(">>>> expected: " + true);
	Test( new TreeNode(-2147483648
			   , null
			   , new TreeNode(2147483647)));


	System.out.println(">>>> expected: " + false);
	Test( new TreeNode(1
			   , null
			   , new TreeNode(1)));

	System.out.println(">>>> expected: " + false);
	Test( new TreeNode(2
			   , new TreeNode(2)
			   , new TreeNode(2)));

	System.out.println(">>>> expected: " + false);
	Test( new TreeNode(2
			   , new TreeNode(0
					  , new TreeNode(1)
					  , null)
			   , new TreeNode(3)));


	System.out.println(">>>> expected: " + true);
	Test( new TreeNode(5
			   , new TreeNode(0
					  , new TreeNode(-1)
					  , new TreeNode(2
							 , new TreeNode(1)
							 , new TreeNode(4)))
			   , new TreeNode(7
					  , new TreeNode(6)
					  , new TreeNode(8))));

    }

    public static boolean isValidBST(TreeNode root) {
	// basic checks
	if (root == null) return false;
	if (root.left == null && root.right == null) return true;

	// smallest number of all nodes visited so far
	long left = Long.MAX_VALUE;
	// current position in the tree
	TreeNode currentNode = root;
	// nodes that require revisit (forks)
	Deque<TreeNode> leftToVisit = new ArrayDeque<>();

	while (currentNode != null) {

	    //
	    // Traverse to the most right node of the root
	    //

	    // before traversing to the right
	    // remember the fork
	    while (currentNode.right != null) {
		leftToVisit.push(currentNode);

		// check the next right node
		if (currentNode.val >= currentNode.right.val) {
		    return false;
		}

		// move to the right
		currentNode = currentNode.right;
	    }

	    //
	    // Check current root value against min value
	    // of all nodes visited so far
	    //

	    // check node and update left value
	    if (left <= currentNode.val) {
		return false;
	    } else {
		left = currentNode.val;
	    }

	    //
	    // Traverse to the left node to repeat the process
	    //

	    // move to the left
	    currentNode = currentNode.left;

	    // if nothing is on the left then
	    // check the next revisit node
	    while (currentNode == null
		   && (currentNode = leftToVisit.poll()) != null) {

		// check the top node value of the fork
		// its value must be less than max
		if (currentNode.val >= left) {
		    return false;
		} else {
		    // update max value
		    left = currentNode.val;
		    // move to the left
		    currentNode = currentNode.left;
		}
	    }
	}

	return true;
    }


    public static void Test(TreeNode root) {
	System.out.println("Input root val: " + root.val);
	boolean result = isValidBST(root);
	System.out.println(">>>> Result: " + result);
	System.out.println();
    }


    static class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
	    this.val = val;
	    this.left = left;
	    this.right = right;
	}
    }
}
