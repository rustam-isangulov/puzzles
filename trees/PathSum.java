package trees;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.ArrayDeque;

class TreeNode {
    long val;
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


/*
Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 */

public class PathSum {
    public static void main(String...  args) {
	System.out.println("PathSum started...");

	test(new Integer[] {10,5,-3,3,2,null,11,3,-2,null,1}, 8);
	test(new Integer[] {1,-2,-3,1,3,-2,null,-1}, -1);
	test(new Integer[] {1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000}, 0);

	System.out.println("PathSum has finished");
    }

    public static void test(Integer[] values, int targetSum) {
	System.out.println();

	System.out.println("Input:");
	System.out.println(Arrays.toString(values));
	System.out.println("target sum: " + targetSum);

	var tree = deserialiseTree(values);

	System.out.println();
	System.out.println("Tree structure:");

	printTree(tree);

	System.out.println();

	System.out.println("Output: " + numberOfPathsWithSum(tree, targetSum));

	System.out.println();
    }

    public static int numberOfPathsWithSum(TreeNode root, int targetSum) {
	// basic check
	if (null == root) return 0;

	// ask how many paths below
	// starting form the current node
	// will have sum equal to reminder
	// remeber it as a currentNum
	var currentNum = numberOfGoogLocalSums(root, targetSum);
	//currentNum = currentNum + numberOfGoogLocalSums(root.right, targetSum - root.val);

	// run numberofpathswithsum for left and right nodes
	var numPathLeft = numberOfPathsWithSum(root.left, targetSum);
	var numPathRight = numberOfPathsWithSum(root.right, targetSum);

	// return total number = currentNum + leftNum + rightNum
	return currentNum + numPathLeft + numPathRight;
    }


    static int numberOfGoogLocalSums(TreeNode root, long targetSum) {
	// basic check
	if (null == root) return 0;

	int retValue = 0;
	long newTarget = targetSum - root.val;

	// reached the goal = +1
	if (newTarget == 0 ) {
	    retValue++;
	}

	// keep going (remember that we can hit the goal again!)
	retValue = retValue
	    + numberOfGoogLocalSums(root.left, newTarget)
	    + numberOfGoogLocalSums(root.right, newTarget);

	return retValue;
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
