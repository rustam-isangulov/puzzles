package trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static trees.PathSum.*;

/*
Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 */

public class PathSumTest {
	private static final PathSum solution = new PathSum();

	@ParameterizedTest
	@MethodSource
    void test(Integer[] values, int targetSum, int expectedOutput) {
		var tree = TreeNode.deserialiseTree(values);
		var result = solution.numberOfPathsWithSum(tree, targetSum);

		Assertions.assertEquals(expectedOutput, result);

    }

	public static Stream<Arguments> test() {
		return Stream.of(
				Arguments.of(
						new Integer[] {10,5,-3,3,2,null,11,3,-2,null,1},
						8,
						3
				),
				Arguments.of(
						new Integer[] {1,-2,-3,1,3,-2,null,-1},
						-1,
						4
				),
				Arguments.of(
						new Integer[]  {1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000},
						0,
						0
				)
		);
	}
}
