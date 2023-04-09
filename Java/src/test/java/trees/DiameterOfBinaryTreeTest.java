package trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static trees.DiameterOfBinaryTree.TreeNode;

/*
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.
 */

public class DiameterOfBinaryTreeTest {
	private static final DiameterOfBinaryTree solution = new DiameterOfBinaryTree();

	@ParameterizedTest
	@MethodSource
    void test(Integer[] nodes, int expectedDiameter) {
		var tree = TreeNode.deserialiseTree(nodes);
		var result = solution.diameterOfBinaryTree(tree);

		Assertions.assertEquals(expectedDiameter, result);
    }

	public static Stream<Arguments> test() {
		return Stream.of(
				Arguments.of(
						new Integer[]{5, 1, 4, null, null, 3, 6},
						3
				),
				Arguments.of(
						new Integer[]{1, 2, 3, 4, 5},
						3
				),
				Arguments.of(
						new Integer[]{5, 3, 7, null, 4, 6},
						4
				),
				Arguments.of(
						new Integer[]{1, 2},
						1
				)
		);
	}
}
