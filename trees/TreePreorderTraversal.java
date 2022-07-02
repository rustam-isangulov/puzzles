package trees;

import java.util.*;

/**
Given the root of an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)

#589 N-ary Tree Preorder Traversal
 */

public class TreePreorderTraversal {
    public static void main(String... args) {
	System.out.println("treePreorderTraversal is starting...");

	Test(null);

	Test(new Node(1, Arrays.asList
		      (new Node(3, Arrays.asList
				(new Node(5, null), new Node(6, null)))
		       , new Node(2, null)
		       , new Node(4, null))));

	Test(new Node(9,null));
    }

    static List<Integer> preorder(Node root) {
	List<Integer> result = new ArrayList<>();

	// iteration #2
	if (root == null) return result;

	Node[] toVisit = new Node[1000];

	int lastIndex = 0;
	toVisit[0] = root;

	Node currentNode = null;

	while (lastIndex >= 0) {
	    currentNode = toVisit[lastIndex--];

	    System.out.println("current node: " +  currentNode.val);

	    while (currentNode != null) {
		result.add(currentNode.val);

		if (currentNode.children != null && currentNode.children.size() > 0) {
		    for(int i = currentNode.children.size() - 1; i > 0; i--)
			{
			    toVisit[++lastIndex] = currentNode.children.get(i);
			}

		    currentNode = currentNode.children.get(0);

		    System.out.print("toVisit: ");
		    if (lastIndex >= 0)
			Arrays.stream(toVisit).limit(lastIndex).forEach(node -> System.out.print(node.val + " "));
		    System.out.println();
		}
		else {
		    currentNode = null;
		}

	    }
	}

	// iteration #1

	// if (root == null) return result;

	// result.add(root.val);

	// if (root.children != null) {
	//     for (var subtree : root.children) {
	// 	result.addAll(preorder(subtree));
	//     }
	// }

	return result;
    }

    static void Test(Node root) {
	System.out.println();
	System.out.println("Input: [" + (root != null ? root.toString() : "") + "]") ;
	List<Integer> result = preorder(root);
	System.out.println("Result: " + result);
    }


    static class Node {
	public int val;
	public List<Node> children;

	public Node() {}

	public Node(int _val) {
	    val = _val;
	}

	public Node(int _val, List<Node> _children) {
	    val = _val;
	    children = _children;
	}

	public String toString() {
	    return Integer.toString(val);
	}
    };
}
