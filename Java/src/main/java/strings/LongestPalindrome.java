package strings;

import java.util.*;

/**
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 * <p>
 * Letters are case-sensitive, for example, "Aa" is not considered a palindrome here.
 */

public class LongestPalindrome {
    public int longestPalindrome( String s ) {

        // iteration #3

        var map = s.chars()
                .collect(HashMap<Integer, Integer>::new
                        , ( m, c ) -> m.merge(c, 1, Integer::sum)
                        , HashMap::putAll);

        // alternative approach to count characters
//        var mapCharsToCount = s.chars()
//                .boxed()
//                .collect(Collectors.toMap(
//                                c -> c,
//                                c -> 1,
//                                Integer::sum
//                        )
//                );

        var result = map.values().stream()
                .filter(count -> count > 1)
                .mapToInt(count -> count - count % 2)
                .sum();

        // much simpler version :)
        if (s.length() > result) result++;

        return result;
    }
}
