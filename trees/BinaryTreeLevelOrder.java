package trees;

import java.util.*;
import java.util.stream.*;

/**
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */

public class BinaryTreeLevelOrder {
    public static void main(String... args) {
	System.out.println("BinaryTreeLevelOrder is starting...");


	Test(null);
	Test(new TreeNode(0, null, null));
	Test(new TreeNode(3
			  , new TreeNode(9)
			  , new TreeNode(20
					 , new TreeNode(15)
					 , new TreeNode(7))));

    }

    static List<List<Integer>> levelOrder(TreeNode root) {
	List<List<Integer>> result = new ArrayList<>();

	if (root == null) return result;

	List<TreeNode> current_level  = new ArrayList<>();
	current_level.add(root);

	while (current_level.size() > 0) {
	    result.add(current_level.stream()
		       .map(node -> node.val)
		       .collect(Collectors.toList()));

	    current_level = current_level.stream()
		.flatMap(node -> Stream.of(node.left, node.right))
		.filter(node -> node != null)
		.collect(Collectors.toList());

	    System.out.println("next level: " + current_level.toString());
	}


	return result;
    }


    static void Test(TreeNode root) {
	System.out.println();
	System.out.println("Input: [" + (root != null ? root.toString() : "") + "]") ;
	List<List<Integer>> result = levelOrder(root);
	System.out.println("Result: " + result);
    }


    static public class TreeNode {
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

	public String toString() {
	    return Integer.toString(val);
	}
    }
}
