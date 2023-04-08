package linkedlists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import linkedlists.StartOfCycle.ListNode;

import static org.junit.jupiter.api.Named.named;

public class StartOfCycleTest {
    private static final StartOfCycle solution = new StartOfCycle();

    @ParameterizedTest( name = "({index}) input: [{0}], expected output: [{1}]" )
    @MethodSource
    void test( ListNode input, ListNode expectedOutput ) {
        ListNode result = solution.startOfCycleNode(input);
        Assertions.assertEquals(
                expectedOutput != null ? expectedOutput.toString() : null,
                result != null ? result.toString() : null
        );
    }

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(
                        named("nodesWithACycle", nodesWithACycle()),
                        ListNode.deserializeList(2)
                ),
                Arguments.of(
                        ListNode.deserializeList(),
                        ListNode.deserializeList()
                ),
                Arguments.of(
                        named("regular nodes list", ListNode.deserializeList(1, 2, 4, 5)),
                        ListNode.deserializeList()
                )
        );
    }

    private static ListNode nodesWithACycle() {
        ListNode start = new ListNode(16);
        ListNode[] nodes = new ListNode[]{
                new ListNode(0),
                new ListNode(1),
                new ListNode(2),
                new ListNode(3),
                new ListNode(-4)};

        start.next = nodes[1];
        nodes[1].next = nodes[2];
        nodes[2].next = nodes[3];
        nodes[3].next = nodes[4];
        nodes[4].next = nodes[2];

        return start;
    }
}
