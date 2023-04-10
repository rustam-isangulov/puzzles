package trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Stream;

import static trees.ValidateBinarySearchTree.*;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */

public class ValidateBinarySearchTreeTest {
    private static final ValidateBinarySearchTree solution = new ValidateBinarySearchTree();

    @ParameterizedTest
    @MethodSource
    void test( TreeNode root, boolean expectedOutput ) {
        boolean result = solution.isValidBST(root);
        Assertions.assertEquals(expectedOutput, result);
    }

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(
                                32,
                                new TreeNode(
                                        26,
                                        new TreeNode(
                                                19,
                                                null,
                                                new TreeNode(27)
                                        ),
                                        null
                                ),
                                new TreeNode(
                                        47,
                                        null,
                                        new TreeNode(56)
                                )
                        ),
                        false
                ),
                Arguments.of(
                        new TreeNode(
                                -2147483648,
                                null,
                                new TreeNode(
                                        2147483647,
                                        new TreeNode(
                                                -2147483648)
                                        ,
                                        null
                                )
                        ),
                        false
                ),
                Arguments.of(
                        new TreeNode(
                                -2147483648,
                                null,
                                new TreeNode(
                                        2147483647
                                )
                        ),
                        true
                ),
                Arguments.of(
                        new TreeNode(
                                5,
                                new TreeNode(
                                        0,
                                        new TreeNode(
                                                -1
                                        ),
                                        new TreeNode(
                                                2,
                                                new TreeNode(
                                                        1
                                                ),
                                                new TreeNode(
                                                        4
                                                )
                                        )
                                ),
                                new TreeNode(
                                        7,
                                        new TreeNode(
                                                6
                                        ),
                                        new TreeNode(
                                                8
                                        )
                                )
                        ),
                        true
                )
        );
    }
}
