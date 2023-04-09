package trees;

import java.util.*;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */

public class ValidateBinarySearchTree {
    public boolean isValidBST( TreeNode root ) {
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

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode( int val ) {
            this.val = val;
        }

        TreeNode( int val, TreeNode left, TreeNode right ) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public String toString() {

            return Integer.toString(this.val);
        }
    }
}
