package search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PivotIndexTest {
	private static final PivotIndex solution = new PivotIndex();

	@ParameterizedTest( name = "({index}) input: {0}, expected pivot index: [{1}]")
	@MethodSource
	void test(int[] input, int expectedIndex) {
		var result = solution.pivotIndex(input);
		Assertions.assertEquals(expectedIndex, result);
	}

	public static Stream<Arguments> test() {
		return Stream.of(
				Arguments.of(new int[]{1, 7, 3, 6, 5, 6}, 3),
				Arguments.of(new int[]{1, 2, 3}, -1),
				Arguments.of(new int[]{2, 1, -1}, 0),
				Arguments.of(new int[]{2, -2, -1}, 2),
				Arguments.of(new int[]{0}, 0)
		);
	}
}
