package search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FirstBadVersionTest {
    private static final FirstBadVersion solution = new FirstBadVersion();

    @ParameterizedTest( name = "({index}) version to check: [{0}], API bad version: [{1}], expected result: [{1}] ")
    @MethodSource
    void test( int version, final int expectedOutput ) {
        int result = solution.findBadVersion(
                version,
                ver -> ver >= expectedOutput
        );

        Assertions.assertEquals(expectedOutput, result);
    }

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(7, 7),
                Arguments.of(2147483647, 2147483644)
        );
    }
}
