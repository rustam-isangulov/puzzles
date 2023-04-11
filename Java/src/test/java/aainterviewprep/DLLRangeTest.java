package aainterviewprep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import aainterviewprep.DLLRange.Node;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Named.named;

public class DLLRangeTest {
    private static Node testHead = null;

    @BeforeAll
    static void init() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.setNext(node2);
        node2.setPrev(node1);
        node2.setNext(node3);
        node3.setPrev(node2);
        node3.setNext(node4);
        node4.setPrev(node3);

        testHead = node1;
    }

    @ParameterizedTest
    @MethodSource
    void test( Node head, Predicate<Node> rule, String expectedOutput ) {
        Node filtered = DLLRange.filter(head, rule);
        Assertions.assertEquals(expectedOutput, filtered != null ? filtered.toString() : "null");
    }

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(
                        testHead,
                        named("values outside of range (6, 9)",
                                lambdaToPredicate(
                                        node -> node.getValue() > 6
                                                && node.getValue() < 9

                                )
                        ),
                        "null"
                ),
                Arguments.of(
                        testHead,
                        named("values in range (2,5)",
                                lambdaToPredicate(
                                        node -> node.getValue() > 2
                                                && node.getValue() < 5

                                )
                        ),
                        " 3 4"
                ),
                Arguments.of(
                        testHead,
                        named("odd values only",
                                lambdaToPredicate(
                                        node -> node.getValue() % 2 != 0
                                )
                        ),
                        " 1 3"
                ),
                Arguments.of(
                        testHead,
                        named("even values only",
                                lambdaToPredicate(
                                        node -> node.getValue() % 2 == 0
                                )
                        ),
                        " 2 4"
                )
        );
    }

    static Predicate<Node> lambdaToPredicate( Predicate<Node> rule ) {
        return rule;
    }
}
