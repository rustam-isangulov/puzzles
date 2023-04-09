package strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 */

public class IsomorphicTest {
	private static final Isomorphic solution = new Isomorphic();

	@ParameterizedTest
	@MethodSource
	void test(String one, String two, boolean expectedOutput) {
		var result = solution.isIsomorphic(one, two);
		Assertions.assertEquals(expectedOutput, result);
	}

	public static Stream<Arguments> test() {
		return Stream.of(
				Arguments.of("egg", "add", true),
				Arguments.of("foo", "bar", false),
				Arguments.of("paper", "title", true),
				Arguments.of("babc", "baba", false)
		);
	}
}
