package strings;

import java.util.Arrays;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix( String[] strs ) {
        // basic checks
        if (strs == null) return "";
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        // any string would do for a base to compare
        char[] base = strs[0].toCharArray();

        var commonMismatchIndex = base.length;
        int nextMismatch;

        for (var s : strs) {
            nextMismatch = Arrays.mismatch(base, s.toCharArray());

            if (nextMismatch > -1 && nextMismatch < commonMismatchIndex) {
                commonMismatchIndex = nextMismatch;
            }
        }

        return new String(base).substring(0, commonMismatchIndex);
    }
}
