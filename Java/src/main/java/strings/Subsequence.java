package strings;

import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
*/

public class Subsequence {
    public boolean isSubsequence( String s, String t ) {
        if (s.length() == 0) {
            return true;
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int sIndex = 0;

        for (int tIndex = 0; tIndex < tArr.length; tIndex++) {
            if (tArr[tIndex] == sArr[sIndex]) {
                if (++sIndex == s.length()) {
                  return true;
                }
            }
        }

        return false;
    }
}
