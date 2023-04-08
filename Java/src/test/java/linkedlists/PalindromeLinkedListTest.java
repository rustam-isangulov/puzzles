package linkedlists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static linkedlists.PalindromeLinkedList.isPalindrome;
import static linkedlists.PalindromeLinkedList.ListNode;

public class PalindromeLinkedListTest {
    private static final PalindromeLinkedList solution = new PalindromeLinkedList();

    @ParameterizedTest(name = "({index}) input: [{0}], expected result: [{1}]")
    @MethodSource
    void test( ListNode inputNode, boolean expectedPalindrome ) {
        boolean result = isPalindrome(inputNode);
        Assertions.assertEquals(expectedPalindrome, result);
    }

    public static Stream<Arguments> test() {
        return Stream.of(
				Arguments.of(
						ListNode.deserializeList(1, 2, 3, 3, 2, 1),
						true
				),
				Arguments.of(
						ListNode.deserializeList(1, 2, 3, 4, 2, 1),
						false
				),
				Arguments.of(
						ListNode.deserializeList(-1),
						true
				),
				Arguments.of(
						ListNode.deserializeList(0, 0),
						true
				),
				Arguments.of(
						ListNode.deserializeList(-1,0),
						false
				)
        );
    }

}
