package sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

/*
tag: sorting

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109
*/

public class MergedArraysTest {
	private static final MergedArrays solution = new MergedArrays();

	@ParameterizedTest(name="({index}) one: {0}, two: {1}, expected merge: {2}")
	@MethodSource
	void test(int[] one, int[] two, int[] expectedOutput) {
		var result = Arrays.copyOf(one, one.length + two.length);
		solution.merge(result, one.length, two, two.length);

		Assertions.assertArrayEquals(expectedOutput,result);
	}

	public static Stream<Arguments> test() {
		return Stream.of(
				Arguments.of(
						new int[]{1, 2, 3, 4},
						new int[]{2, 5, 6},
						new int[]{1, 2, 2, 3, 4, 5, 6}
				),
				Arguments.of(
						new int[]{1},
						new int[]{0},
						new int[]{0, 1}
				),
				Arguments.of(
						new int[]{0},
						new int[]{1},
						new int[]{0, 1}
				),
				Arguments.of(
						new int[]{-1, 0, 0, 1, 2, 3},
						new int[]{-2,5,6},
						new int[]{-2, -1, 0, 0, 1, 2, 3, 5, 6}
				)
		);
	}
}
