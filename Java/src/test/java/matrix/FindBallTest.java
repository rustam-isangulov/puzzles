package matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Named.named;

public class FindBallTest {
    private static final FindBall solution = new FindBall();

    @ParameterizedTest(name = "({index}) {0}, expected output: [{1}]")
    @MethodSource
    public void test( int[][] grid, int[] expectedOutput ) {
        var output = solution.findBall(grid);
        Assertions.assertArrayEquals(expectedOutput, output);
    }

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(
                        named("one ball starts at 0 exists at 1",
                                (Object) new int[][]{
                                        {1, 1, 1, -1, -1}
                                        , {1, 1, 1, -1, -1}
                                        , {-1, -1, -1, 1, 1}
                                        , {1, 1, 1, 1, -1}
                                        , {-1, -1, -1, -1, -1}
                                }
                        ),
                        new int[]{1, -1, -1, -1, -1}
                ),
                Arguments.of(
                        named("one ball starts at 5 and gets stuck",
                                (Object) new int[][]{
                                        {1, 1, 1, 1, 1, 1}
                                        , {-1, -1, -1, -1, -1, -1}
                                        , {1, 1, 1, 1, 1, 1}
                                        , {-1, -1, -1, -1, -1, -1}
                                }
                        ),
                        new int[]{0, 1, 2, 3, 4, -1}
                ),
                Arguments.of(
                        named("single square, single ball gets stuck",
                                (Object) new int[][]{{-1}}
                        ),
                        new int[]{-1}
                ),
                Arguments.of(
                        named("single square, single ball gets stuck",
                                (Object) new int[][]{{1}}
                        ),
                        new int[]{-1}
                ),
                Arguments.of(
                        named("giant example",
                                (Object) new int[][]{
                                        {1, -1, -1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -1, 1, -1, 1, -1, 1, -1, -1, -1, -1, 1, -1, 1, 1, -1, -1, -1, -1, -1, 1}
                                        , {-1, 1, 1, 1, -1, -1, -1, -1, 1, 1, 1, -1, -1, -1, 1, -1, -1, 1, 1, 1, 1, 1, 1, -1, 1, -1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, 1, 1, -1, 1, 1}
                                        , {1, -1, -1, -1, -1, 1, -1, 1, 1, 1, 1, 1, 1, 1, -1, 1, -1, -1, -1, 1, -1, -1, 1, -1, 1, -1, 1, -1, -1, 1, -1, 1, -1, 1, 1, -1, -1, 1, 1, -1, 1, -1}}
                        ),
                        new int[]{-1, -1, 1, -1, -1, -1, -1, 10, 11, -1, -1, 12, 13, -1, -1, -1, -1, -1, 17, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, 27, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}
                )
        );
    }
}
