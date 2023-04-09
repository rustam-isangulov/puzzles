package search;

/*
tag: search

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
*/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TwoSumTest {
	private static final TwoSum solution = new TwoSum();

	@ParameterizedTest( name = "({index}) input: {0}, target sum: [{1}], expected indices: {2}")
	@MethodSource
	void test(int[] input, int target, int[] expectedIndices) {
		var result = solution.twoSum(input, target);
		Assertions.assertArrayEquals(expectedIndices, result);
	}

	public static Stream<Arguments> test() {
		return Stream.of(
				Arguments.of( new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
				Arguments.of( new int[]{3, 3}, 6, new int[]{0, 1}),
				Arguments.of( new int[]{0, 3, 4, 0}, 0, new int[]{0, 3}),
				Arguments.of( new int[]{3, 2, 4}, 6, new int[]{1, 2})
		);
	}

}
