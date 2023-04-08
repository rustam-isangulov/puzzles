package linkedlists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import linkedlists.MergeTwoSorted.ListNode;

public class MergeTwoSortedTest {
    private static final MergeTwoSorted solution = new MergeTwoSorted();

    @ParameterizedTest(name = "({index}) one: [{0}], two: [{1}], expected: [{2}]")
    @MethodSource
    void test( ListNode list1, ListNode list2, ListNode expectedOutput ) {
        ListNode result = solution.mergeTwoLists(list1, list2);
        Assertions.assertEquals(
				expectedOutput != null ? expectedOutput.toString() : null,
				result != null ? result.toString() : null);
    }

    static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(
                        ListNode.deserializeList(1, 2, 4),
                        ListNode.deserializeList(1, 3, 4),
                        ListNode.deserializeList(1, 1, 2, 3, 4, 4)
                ),
				Arguments.of(
						null,
						null,
						null
				),
				Arguments.of(
						null,
						ListNode.deserializeList(1, 3, 4),
						ListNode.deserializeList(1, 3, 4)
				),
				Arguments.of(
						ListNode.deserializeList(1, 3, 4),
						null,
						ListNode.deserializeList(1, 3, 4)
				)
		);
    }
}
