package strings;

import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
*/

public class Subsequence {
    public static void main(String... args) {
	System.out.println("Subsequence is starting...");

	Test("b", "abc");
	Test("abc", "ahbgdc");
	Test("", "ahbgdc");
	Test("", "");
	Test("", "a");
	Test("a", "");
	Test("abc", "aaaaaacccccbbbbabc");
	Test("rjufvjafbxnbgriwgokdgqdqewn"
	     , "mjmqqjrmzkvhxlyruonekhhofpzzslupzojfuoztvzmmqvmlhgqxehojfowtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuaktupfftiljwpgglkjqunvithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnznddkiujwhdefziydtquoudzxstpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifinccvqzwlbmgpdaodzptyrjjkbqmgdrftfbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkgwafohflvuedssukjgipgmypakhlckvizmqvycvbxhlljzejcaijqnfgobuhuiahtmxfzoplmmjfxtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfpszzomumfqpaiydssmihdoewahoswhlnpctjmkyufsvjlrflfiktndubnymenlmpyrhjxfdcq");
    }


    static public boolean isSubsequence(String s, String t) {
	boolean result = false;

	if (s.length() == 0) {
	    return true;
	}

	char[] sArr = s.toCharArray();
	char[] tArr = t.toCharArray();

	int sIndex = 0;

	for (int tIndex = 0; tIndex < tArr.length; tIndex++) {
	    if (tArr[tIndex] == sArr[sIndex]) {
		if (++sIndex == s.length()) {
		    result = true;
		    break;
		}
	    }
	}

	return result;

	// itaration #1 [FAIL: long patterns take too long => need to optimize the use of regex]

	/* var pattern = s.chars().collect */
	/*     (()-> new StringBuilder("") */
	/*      , (b, c) -> b.append((char)c).append("+(.*)?") */
	/*      , StringBuilder::append); */

	/* if (s.length() > 0) { */
	/*     pattern.setLength(pattern.length() - 5); */
	/* } else { */
	/*     pattern.append(".*"); */
	/* } */

	/* System.out.println("pattern: " + pattern); */

	/* Pattern p = Pattern.compile(pattern.toString()); */
	/* Matcher m = p.matcher(t); */
	/* result = m.reset(t).find(0); */

	/* //result = Pattern.matches(pattern.toString(), t); */

	//return result;
    }


    static void Test(String s, String t) {
	System.out.println();
	System.out.println("Input s: [" + s + "] t: [" + t + "]") ;
	boolean result = isSubsequence(s, t);
	System.out.println("Result: " + result);
    }
}
