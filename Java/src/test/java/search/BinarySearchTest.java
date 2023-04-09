package search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BinarySearchTest {
    private static final BinarySearch solution = new BinarySearch();

    @ParameterizedTest( name = "({index}) array: {0}, target value: [{1}], expected index: [{2}]")
    @MethodSource
    void test( int[] nums, int target, int expectedOutput ) {
        int result = solution.search(nums, target);
        Assertions.assertEquals(expectedOutput, result);
    }

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(new int[]{-1,0,3,5,9,12}, 9, 4),
                Arguments.of(new int[]{-100, 400, 1000}, 500, -1),
                Arguments.of(null, 9, -1),
                Arguments.of(new int[]{4}, 4, 0)
        );
    }
}
