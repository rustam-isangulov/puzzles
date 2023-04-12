package aainterviewprep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Named.named;

public class NumbersFilterTest {
    private static final NumbersFilter solution = new NumbersFilter();


    @ParameterizedTest
    @MethodSource
    void test( List<Integer> numbers, Predicate<Integer> rule, int expectedOutput ) {
        var result = solution.countByRule(numbers, rule);

        Assertions.assertEquals(expectedOutput, result);
    }

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(
                        List.of(1, 2, 3, 4, 5),
                        named(
                                "count all even numbers",
                                lambdaToPredicate(
                                        num -> num % 2 == 0
                                )
                        ),
                        2
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5),
                        named(
                                "count all odd numbers",
                                lambdaToPredicate(
                                        num -> num % 2 != 0
                                )
                        ),
                        3
                )
        );
    }

    static Predicate<Integer> lambdaToPredicate( Predicate<Integer> rule ) {
        return rule;
    }
}
