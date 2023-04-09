package strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.awt.*;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 * <p>
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 */

public class LongestPalindromeTest {
    private static final LongestPalindrome solution = new LongestPalindrome();

    @ParameterizedTest
    @MethodSource
    void test( String s, int expectedOutput ) {
        System.out.println();
        System.out.println("Input s: [" + s + "]");
        int result = solution.longestPalindrome(s);
        System.out.println("Result: " + result);
        Assertions.assertEquals(expectedOutput, result);
    }

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of("aaa", 3),
                Arguments.of("abcCCcdd", 7),
                Arguments.of("abccccdd", 7),
                Arguments.of("a", 1),
                Arguments.of("aA", 1)
        );
    }
}
