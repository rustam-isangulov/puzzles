package trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Named.named;
import static trees.BinaryTreeLevelOrder.*;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */

public class BinaryTreeLevelOrderTest {
    private static final BinaryTreeLevelOrder solution = new BinaryTreeLevelOrder();

    @ParameterizedTest
    @MethodSource
    void test( TreeNode root, List<List<Integer>> expectedOutput ) {
        List<List<Integer>> result = solution.levelOrder(root);
        Assertions.assertEquals(expectedOutput, result);
    }

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(
                        named(
                                "example from the problem",
                                new TreeNode(
                                        3,
                                        new TreeNode(9),
                                        new TreeNode(
                                                20,
                                                new TreeNode(15),
                                                new TreeNode(7)
                                        )
                                )
                        ),
                        List.of(List.of(3), List.of(9, 20), List.of(15, 7))
                ),
                Arguments.of(
                        named(
                                "single note with two null descendants",
                                new TreeNode(0, null, null)
                        ),
                        List.of(List.of(0))
                ),
                Arguments.of(
                        null,
                        List.of()
                )
        );
    }
}
