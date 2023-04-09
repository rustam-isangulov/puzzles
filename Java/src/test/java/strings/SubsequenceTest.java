package strings;

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
*/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SubsequenceTest {
    private static final Subsequence solution = new Subsequence();

    @ParameterizedTest(name = "({index}) sub: \"{0}\", string: \"{1}\", expected output: {2}")
    @MethodSource
    void test( String s, String t, boolean expectedOutput) {
        boolean result = solution.isSubsequence(s, t);
        Assertions.assertEquals(expectedOutput, result);
    }

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of("b" , "abc", true),
                Arguments.of("abc" , "ahbgdc", true),
                Arguments.of("", "ahbgdc", true),
                Arguments.of("", "", true),
                Arguments.of("abc", "aaaaaacccccccbbbbbbdddd", false),
                Arguments.of("a", "", false),
                Arguments.of("abc", "aaaaaacccccbbbbabc", true),
                Arguments.of(
                        "rjufvjafbxnbgriwgokdgqdqewn"
                        , "mjmqqjrmzkvhxlyruonekhhofpzzslupzojfuoztvzmmqvmlhgqxehojfowtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuaktupfftiljwpgglkjqunvithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnznddkiujwhdefziydtquoudzxstpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifinccvqzwlbmgpdaodzptyrjjkbqmgdrftfbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkgwafohflvuedssukjgipgmypakhlckvizmqvycvbxhlljzejcaijqnfgobuhuiahtmxfzoplmmjfxtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfpszzomumfqpaiydssmihdoewahoswhlnpctjmkyufsvjlrflfiktndubnymenlmpyrhjxfdcq"
                        , false
                )
        );
    }
}
