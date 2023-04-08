package linkedlists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import linkedlists.MiddleOfList.ListNode;

public class MiddleOfListTest {
    private static final MiddleOfList solution = new MiddleOfList();

    @ParameterizedTest(name = "({index}) input: [{0}], expected output: [{1}]")
    @MethodSource
    void test( ListNode input, ListNode expectedOutput ) {
        ListNode result = solution.middleNode(input);
		Assertions.assertEquals(
				expectedOutput != null ? expectedOutput.toString() : null,
				result != null ? result.toString() : null
		);
    }

	public static Stream<Arguments> test() {
		return Stream.of(
				Arguments.of(
						new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(5)))),
						new ListNode(4, new ListNode(5))
				),
				Arguments.of(
						new ListNode(1, new ListNode(3, new ListNode(4))),
						new ListNode(3, new ListNode(4))
				),
				Arguments.of(
						null,
						null
				)
		);
	}
}