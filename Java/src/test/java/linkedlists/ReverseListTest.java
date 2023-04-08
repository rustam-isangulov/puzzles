package linkedlists;

/*
Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import linkedlists.ReverseList.ListNode;

public class ReverseListTest {
    private static final ReverseList solution = new ReverseList();

    @ParameterizedTest( name="({index}) input: [{0}], expected output: [{1}]" )
    @MethodSource
    void test( ListNode inputNode, ListNode expectedOutput ) {
        ListNode result = solution.reverseList(inputNode);
        Assertions.assertEquals(
                expectedOutput != null ? expectedOutput.toString() : null,
                result != null ? result.toString() : null
        );
    }

    public static Stream<Arguments> test() {
        return Stream.of(
				Arguments.of(
						ListNode.deserializeList(1, 3, 4),
						ListNode.deserializeList(4, 3, 1)
				),
				Arguments.of(
						ListNode.deserializeList(1, 2, 4, 5),
						ListNode.deserializeList(5, 4, 2, 1)
				),
				Arguments.of(
						ListNode.deserializeList(),
						ListNode.deserializeList()
				)
        );
    }
}
