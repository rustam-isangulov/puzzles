package trees;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

/*
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.
 */

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree( TreeNode root ) {
        if (null != root) {
            // find the longest path that goes through this node
            int rootD =
                    ((null != root.left) ? maxDepth(root.left) + 1 : 0)
                            + ((null != root.right) ? maxDepth(root.right) + 1 : 0);

            // get max path for the left and the right sides
            int descendantsD = Math.max(
                    diameterOfBinaryTree(root.left),
                    diameterOfBinaryTree(root.right)
            );

            // choose the max out of three
            return Math.max(rootD, descendantsD);
        }

        return 0;
    }

    // counting max number of edges
    // between this node and farthest
    // descendant
    public int maxDepth( TreeNode root ) {
        if (null != root && (null != root.left || null != root.right)) {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }

        return 0;
    }

    static public class TreeNode {
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

        public static TreeNode deserialiseTree(Integer[] nodes) {
            // BFS approach naturally using Queue
            Queue<TreeNode> parentQueue = new ArrayDeque<>();

            // set the root node
            TreeNode tree = new TreeNode(nodes[0]);
            parentQueue.offer(tree);

            // starting position for node value
            int index = 1;

            TreeNode nextParent;
            Integer nodeValue;

            while (index < nodes.length) {
                // get parent node for the next two values
                nextParent = parentQueue.poll();

                // left
                if ((nodeValue = nodes[index++]) !=null) {

                    var newNode = new TreeNode(nodeValue);
                    nextParent.left = newNode;

                    parentQueue.offer(newNode);
                }

                // right
                if ((index < nodes.length)
                        && ((nodeValue = nodes[index++]) != null)) {

                    var newNode = new TreeNode(nodeValue);
                    nextParent.right = newNode;

                    parentQueue.offer(newNode);
                }
            }

            return tree;
        }

        static void printTree(TreeNode root) {
            // BFS approach
            List<TreeNode> parents = new ArrayList<>();
            List<TreeNode> descendants = new ArrayList<>();

            // set the root node
            parents.add(root);

            while (parents.size() > 0) {
                parents.forEach(node -> {
                    if (null != node) {
                        System.out.print(node.val + " ");
                        descendants.add(node.left);
                        descendants.add(node.right);
                    } else {
                        System.out.print("null ");
                    }
                });

                System.out.println();

                parents.clear();

                // if we have non-null descendants then continue moving level down
                if (descendants.stream().filter(e -> null != e).count() > 0) {
                    parents.addAll(descendants);
                    descendants.clear();
                }
            }
        }
    }
}
