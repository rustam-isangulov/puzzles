package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class WaveArrayTest {
    private static final WaveArray waveArray = new WaveArray();

    @ParameterizedTest(name = "({index}) input: {0}, expected output: {1}")
    @MethodSource
    void test( int[] input, int[] expectedOutput ) {
        var output = waveArray.getWaveArray(input);
        Assertions.assertArrayEquals(expectedOutput, output);
    }

    static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        new int[]{2, 1, 4, 3, 5}
                ),
                Arguments.of(
                        new int[]{},
                        new int[]{}
                ),
                Arguments.of(
                        new int[]{-1, -1, -1},
                        new int[]{-1, -1, -1}
                )
        );
    }
}
