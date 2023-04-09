package matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SpiralOrderTest {
    private static final SpiralOrder solution = new SpiralOrder();

    @ParameterizedTest
    @MethodSource
    public void test( int[][] matrix, List<Integer> expectedOutput ) {
        var output = solution.spiralOrder(matrix);
        Assertions.assertEquals(expectedOutput, output);
    }

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(
                        (Object) new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}},
                        List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)
                ),
                Arguments.of(
                        (Object) new int[][]{{1, 2, 3, 4}},
                        List.of(1, 2, 3, 4)
                ),
                Arguments.of(
                        (Object) new int[][]{{}},
                        List.of()
                )
        );
    }
}
