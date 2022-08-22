package trees;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.ArrayDeque;

class TreeNode {
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


/*
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 */

public class SortedArrayToBST {
    public static void main(String... args) {
	System.out.println("SortedArrayToBST is starting...");

	test(new int[]{0});
	test(new int[]{-1, 1});
	test(new int[]{-10,-3,0,5,9});

	System.out.println("SortedArrayToBST has finished.");
    }

    static void test(int[] nums) {
	System.out.println();

	System.out.println("Input: " + Arrays.toString(nums));

	var tree = sortedArrayToBST(nums);

	System.out.println("Output tree:");

	printTree(tree);

	System.out.println();
    }


    static TreeNode sortedArrayToBST(int[] nums) {
	if (null == nums || nums.length == 0) return null;

	// Solution: recursive
	// get index of median (remember the array is sorted already)
	// create a node with the median value
	// set left subtree reference to the result of recursive call for subarray left of the median
	// set right subtree reference to the result of recircive call for subarry right of the median
	// return the root node

	TreeNode root = bstSubArray(nums, 0, nums.length);

	return root;
    }


    static TreeNode bstSubArray(int[] nums, int start, int end) {
	// get median for the sorted array
	int medianIndex = (end + start) / 2;

	// we are outside of nums
	// nothing to process anymore
	if (medianIndex == end) return null;

	TreeNode root = new TreeNode(nums[medianIndex]);

	// we have more to procees
	if( start < medianIndex){
	    root.left = bstSubArray(nums, start, medianIndex);
	    root.right = bstSubArray(nums, medianIndex + 1, end);
	    return root;
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
