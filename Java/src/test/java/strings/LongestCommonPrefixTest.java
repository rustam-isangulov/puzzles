package strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
 */

public class LongestCommonPrefixTest {
    private static final LongestCommonPrefix solution = new LongestCommonPrefix();

    @ParameterizedTest
    @MethodSource
    void test( String[] words, String expectedPrefix ) {
        var output = solution.longestCommonPrefix(words);
        Assertions.assertEquals(expectedPrefix, output);
    }

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(new String[]{"flower", "flow", "flight"}, "fl"),
                Arguments.of(new String[]{"flower", "flow", ""}, ""),
                Arguments.of(new String[]{"flower", "dlow", "flight"}, "")
        );
    }
}
