package math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class HappyNumberTest {
    private static final HappyNumber solution = new HappyNumber();

    @ParameterizedTest( name = "({index}) input: [{0}], expected output: [{1}] ")
    @MethodSource
    public void test( int n, boolean expectedOutput ) {
        var result = solution.isHappy(n);
        Assertions.assertEquals(expectedOutput, result);
    }

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(2, false),
                Arguments.of(42, false),
                Arguments.of(301, true),
                Arguments.of(19, true)
        );
    }
}
