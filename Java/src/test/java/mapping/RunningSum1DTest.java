package mapping;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RunningSum1DTest {
	private static final RunningSum1D solution = new RunningSum1D();

	@ParameterizedTest( name = "({index}) input: {0}, expected output: {1}")
	@MethodSource
	void test( int[] input, int[] expectedOutput ) {
		var result = solution.runningSum(input);
		Assertions.assertArrayEquals(expectedOutput, result);
	}

	public static Stream<Arguments> test() {
		return Stream.of(
				Arguments.of(
						new int[] {1, 2, 3, 4},
						new int[] {1, 3, 6, 10}
				),
				Arguments.of(
						new int[] {2},
						new int[] {2}
				),
				Arguments.of(
						new int[] {},
						new int[] {}
				)
		);
	}
}
