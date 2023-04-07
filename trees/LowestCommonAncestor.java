package trees;

import java.util.*;
import java.util.stream.*;

/**

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

*/

public class LowestCommonAncestor {
    public static void main(String... args) {
	System.out.println("LowestCommonAncestor is starting...");

	StringBuilder a = new StringBuilder(".".repeat(15));

	int num = 1;
	num = num%1000;

	String n = "(" + String.format("%03d", num) + ")";

	for (int i = a.length()-1; i >=0; i-=2) {
	    a.replace(i,i+1,n);
	}

	int numNodesBottom = 8;
	int nodePrintLength = 5;

	int levelLength =
	    numNodesBottom * nodePrintLength    // total display length for all nodes
	    + (numNodesBottom - 1);             // total length of single gaps between nodes

	int level = 0;
 	int gap = ((int)Math.pow(2,level+1)) - 1;
	int offset = ((int)Math.pow(2,level)) - 1;

	List<Integer> lev0Nodes = IntStream.range(1, 9).boxed().collect(Collectors.toList());

	level = 0;
 	gap = ((int)Math.pow(2,level+1)) - 1;
	offset = ((int)Math.pow(2,level)) - 1;

	String offsetString = ".".repeat(offset);
	String gapString = ".".repeat(gap);

	String lev0 = offsetString + lev0Nodes.stream()
	    .map(e ->  "(" + String.format("%03d", e) + ")")
	    .collect(Collectors.joining(gapString));

	System.out.println(lev0 + " new: " + lev0.length());

	List<Integer> lev1Nodes = IntStream.range(1, 5).boxed().collect(Collectors.toList());

	level = 1;
 	gap = ((int)Math.pow(2,level+1)) - 1;
	offset = ((int)Math.pow(2,level)) - 1;

	offsetString = ".".repeat(offset + nodePrintLength / 2 );
        gapString = ".".repeat(gap + ((int)Math.pow(2,level) - 1) * (2*(nodePrintLength / 2)));

	String lev1 = offsetString + lev1Nodes.stream()
	    .map(e ->  "(" + String.format("%03d", e) + ")")
	    .collect(Collectors.joining(gapString));

	System.out.println(lev1 + " new: " + lev1.length());


	List<Integer> lev2Nodes = IntStream.range(1, 3).boxed().collect(Collectors.toList());

	level = 2;
 	gap = ((int)Math.pow(2,level+1)) - 1;
	offset = ((int)Math.pow(2,level)) - 1;

	offsetString = ".".repeat(offset + 3 * (nodePrintLength / 2) );
        gapString = ".".repeat(gap + ((int)Math.pow(2,level) - 1) * (2*(nodePrintLength / 2)));

	String lev2 = offsetString + lev2Nodes.stream()
	    .map(e ->  "(" + String.format("%03d", e) + ")")
	    .collect(Collectors.joining(gapString));

	System.out.println(lev2 + " new: " + lev2.length());

	System.out.println("#".repeat(20));

	List<List<Integer>> levels = new ArrayList<>();
	levels.add(IntStream.range(1,2).boxed().collect(Collectors.toList()));
	levels.add(IntStream.range(1,3).boxed().collect(Collectors.toList()));
	levels.add(IntStream.range(1,5).boxed().collect(Collectors.toList()));
	levels.add(IntStream.range(1,9).boxed().collect(Collectors.toList()));
	levels.add(IntStream.range(1,17).boxed().collect(Collectors.toList()));

	levels.get(4).set(4, null);
	levels.get(4).set(5, -4);

	//printBinaryTreeLevels(levels);

	System.out.println("#".repeat(20));


	List<Integer> gapIndices = IntStream.iterate(n.length(), i -> i < 47, i -> i + n.length()+1)
	    .boxed()
	    .collect(Collectors.toList());

	System.out.println(gapIndices);

	System.out.println(a + " lenght: " + a.length());


	var secondLevelIndices = IntStream.range(0, gapIndices.size())
	    .filter(e -> (e - 0) % ((int)Math.pow(2,1)) == 0)
	    .mapToObj(gapIndices::get)
	    .collect(Collectors.toList());

	//System.out.println(secondLevelIndices);

	StringBuilder a2 =new StringBuilder(".".repeat(47));

	for( var index : secondLevelIndices) {
	    int startPos = index - n.length() / 2;
	    a2.replace(startPos, startPos + n.length(), n);
	}

	System.out.print(a2);
	System.out.println(" length: " + a2.length());



	var thirdLevelIndices = IntStream.range(0, gapIndices.size())
	    .filter(e -> (e - (((int)Math.pow(2,1)) - 1)) % ((int)Math.pow(2,2)) == 0)
	    .mapToObj(gapIndices::get)
	    .collect(Collectors.toList());

	StringBuilder a3 =new StringBuilder(".".repeat(47));

	for( var index : thirdLevelIndices) {
	    int startPos = index - n.length() / 2;
	    a3.replace(startPos, startPos + n.length(), n);
	}

	System.out.print(a3);
	System.out.println(" length: " + a3.length());

	var fourthLevelIndices = IntStream.range(0, gapIndices.size())
	    .filter(e -> (e - (((int)Math.pow(2,2)) - 1)) % ((int)Math.pow(2,3)) == 0)
	    .mapToObj(gapIndices::get)
	    .collect(Collectors.toList());

	StringBuilder a4 =new StringBuilder(".".repeat(47));

	for( var index : fourthLevelIndices) {
	    int startPos = index - n.length() / 2;
	    a4.replace(startPos, startPos + n.length(), n);
	}

	System.out.print(a4);
	System.out.println(" length: " + a4.length());


	int lNode = 5;
	int x = 4;

	int g = (a.length() - x * lNode) / (x -1);
	int k2 = (a.length() - x * lNode) % (x -1);

	System.out.println("a : " + a.length() + " x: " + x + " g: " + g + " k2: " + k2);


	a = new StringBuilder(".".repeat(15));

	for (int i = a.length() - 2; i >=0; i-=4) {
	    a.replace(i,i+1,n);
	}

	System.out.println(a + " length: " + a.length());



	a = new StringBuilder(".".repeat(15));

	for (int i = a.length() - 4; i >=0; i-=8) {
	    a.replace(i,i+1,n);
	}

	System.out.println(a);

	a = new StringBuilder(".".repeat(15));

	for (int i = a.length() - 8; i >=0; i-=16) {
	    a.replace(i,i+1,n);
	}

	System.out.println(a);


	//TreeNode.of(66,22,-88,0,44,77,99,null,null,-33,55);
	TreeNode.of(5,4,7,3,null,2,null,-1,null,9);

    }


    static void printBinaryTreeLevels(List<List<TreeNode>> levels) {
	int numLevels = levels.size();
	String postsetString = "";
	int level = 0;
	int gap;
	int offset;
	String offsetString;
	String gapString;
	int nodePrintLength = 3;

	for(int lev = 0; lev < numLevels; lev++) {
	    level = numLevels - 1 - lev;
	    gap = ((int)Math.pow(2,level+1)) - 1;
	    offset = ((int)Math.pow(2,level)) - 1;

	    offsetString = ".".repeat(offset + (((int)Math.pow(2,level)) - 1) * (nodePrintLength / 2) );
	    gapString = " ".repeat(gap + ((int)Math.pow(2,level) - 1) * (2*(nodePrintLength / 2)));

	    if (level > 0) {
		int realOffset = offset + (((int)Math.pow(2,level)) - 1) * (nodePrintLength / 2);
		int hOffset = realOffset / 2;

		offsetString = " ".repeat(realOffset - hOffset) + ".".repeat(hOffset);
		postsetString = ".".repeat(hOffset);

		int realGap = gap + ((int)Math.pow(2,level) - 1) * (2*(nodePrintLength / 2));
		int qGap  = realGap / 4;
		gapString = ".".repeat(qGap) + " ".repeat(realGap - 2*qGap) + ".".repeat(qGap);
	    } else {
		postsetString = "";
	    }

	    String levStr = offsetString
		+ levels.get(lev).stream()
		.map(e ->  "" + (e != null ? String.format("%03d", e.val) : "   ") + "")
		.collect(Collectors.joining(gapString))
		+ postsetString;

	    System.out.println(levStr);

	}
    }

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	return root;
    }


    static void Test(TreeNode root, TreeNode p, TreeNode q) {
	System.out.println();
	System.out.println("root node: " + root.val);
	TreeNode lca = lowestCommonAncestor(root, p, q);
	System.out.println("result: " + lca.val);
    }


    static public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }


	public static void print(TreeNode root) {
	    List<List<TreeNode>> listOfLevels = new ArrayList<>();
	    listOfLevels.add(List.of(root));

	    List<TreeNode> nodesToProcess = listOfLevels.get(0);

	    System.out.println();

	    while (nodesToProcess.size() > 0) {
		var currLevel = new ArrayList<TreeNode>();

		// String nodesString = nodesToProcess.stream()
		//     .map(node -> node != null ? "" + node.val : "null")
		//     .collect(Collectors.joining("|"));

		// System.out.println("node print: [" + nodesString + "]");


		for (var node : nodesToProcess) {
		    currLevel.add(node != null ? node.left : null);
		    currLevel.add(node != null ? node.right : null);
		}

		if (currLevel.stream().anyMatch(node -> node != null)){
		    listOfLevels.add(currLevel);
		    nodesToProcess = currLevel;
		} else {
		    nodesToProcess = List.of();
		}
	    }

	    int bottomLevelSize = listOfLevels.get(listOfLevels.size() - 1).size();

	    System.out.println();

	    printBinaryTreeLevels(listOfLevels);

	    for (var level : listOfLevels) {

		// System.out.print("level: [");
		// System.out.print(level.stream()
		// 		 .map(node -> node != null ? Integer.toString(node.val) : null + "")
		// 		 .collect(Collectors.joining(" ")));
		// System.out.println("]");

		int offset = bottomLevelSize / level.size();
		String blankStep = " ".repeat(2*offset - 2*(offset/2) - 1);
		String dotPath = "_".repeat(offset/2);

		System.out.print(" ".repeat( offset < 2 ? 0 : offset/2 - 1 ));

		for (var node : level) {
		    System.out.print( dotPath + (node != null ? node.val : " ") + dotPath + blankStep);
		}

		System.out.println();
	    }
	}


	public static TreeNode of(Integer... nodeList) {

	    // System.out.print("[");
	    // Arrays.stream(nodeList).forEach(node -> System.out.print(node + " "));
	    // System.out.println("]");

	    Deque<Integer> nodeStack = new LinkedList<>(Arrays.asList(nodeList));
	    Deque<TreeNode> topLevel = new ArrayDeque<>();
	    Deque<TreeNode> currLevel = new ArrayDeque<>();
	    Integer nextNode = null;
	    TreeNode parentNode = null;

	    TreeNode root = nodeStack.peek() != null ? new TreeNode(nodeStack.poll()) : null;

	    topLevel.push(root);

	    System.out.println(root.val);

	    while (nodeStack.size() > 0) {
		// get next two nodes from the pool
		// and assign to the next top level node
		// as right and left subnodes
		if ((parentNode = topLevel.poll()) != null) {
		    if ((nextNode = nodeStack.poll()) != null) {
			parentNode.left = new TreeNode(nextNode);
		    } else {
			parentNode.left = null;
		    }

		    if ((nextNode = nodeStack.poll()) != null) {
			parentNode.right = new TreeNode(nextNode);
		    } else {
			parentNode.right = null;
		    }

		    if (parentNode.left != null) currLevel.add(parentNode.left);
		    if (parentNode.right != null) currLevel.add(parentNode.right);

		    System.out.print((parentNode.left != null ? parentNode.left.val : null) + " "
				     + (parentNode.right != null ? parentNode.right.val : null) + " ");



		} else {
		    // System.out.println();

		    // String currLevelString = currLevel.stream()
		    // 	.map(node -> node != null ? "" + node.val : "" + null)
		    // 	.collect(Collectors.joining("|"));
		    // System.out.println("\t [" + currLevelString + "]");

		    // when run out of top level nodes
		    // assign subnodes level to be top level
		    // for the next level
		    var temp = topLevel;
		    topLevel = currLevel;
		    currLevel = temp;

		}
	    }

	    TreeNode.print(root);

	    return root;
	}
    }
}
