package strings;

import java.util.*;
import java.util.stream.*;

/**
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 */

public class LongestPalindrome {
    public static void main(String... args) {
	System.out.println("LongestPalindrome is starting...");

	Test("aaa");
	Test("abcCCcdd");
	Test("abccccdd");
	Test("a");
	Test("aA");
    }

    static int longestPalindrome(String s) {

	// iteration #3

	var map = s.chars()
	    .collect(HashMap<Integer, Integer>::new
		     , (m, c) -> m.merge(c, 1, (c1, c2) -> c1+c2)
		     , (m1, m2) -> m1.putAll(m2));

	System.out.println(map);

	var result = map.values().stream()
	    .filter(count -> count > 1)
	    .mapToInt(count -> count - count%2)
	    .sum();

	System.out.println("total number of even chars: " + result);

	// much simpler version :)
	if (s.length() > result) result++;


	// iteration #2

	// var map = s.chars()
	//     .boxed()
	//     .collect(Collectors.toMap
	// 	     (c -> c
	// 	      , c -> 1
	// 	      , (n1, n2) -> n1 + n2));

	// System.out.println(map);

	// var result = map.values().stream()
	//     .filter(count -> count > 1)
	//     .mapToInt(count -> count - count%2)
	//     .sum();

	// System.out.println("total number of even chars: " + result);

	// // much simpler version :)
	// if (s.length() > result) result++;


	// Iteration #1

	// var map = s.chars()
	//     .boxed()
	//     .collect(Collectors.groupingBy(c -> c
	// 				   , Collectors.counting()));

	// System.out.println(map);

	// var result = map.values().stream()
	//     .mapToLong(count -> (count / 2) * 2)
	//     .sum();

	// System.out.println("total number of even chars: " + result);

	// // much simpler version :)
	// if (s.length() > result) result++;

	// find if any extra char is available to build a palindrome (with findAny())
	// Optional<Long> nonEvenElement = map.values().stream().filter(count -> count % 2 > 0).findAny();
	// nonEvenElement.ifPresent(e -> System.out.println("extra char is available"));
	// if( nonEvenElement.isPresent() ) result++;

	return (int)result;
    }


    static void Test(String s) {
	System.out.println();
	System.out.println("Input s: [" + s + "]") ;
	int result = longestPalindrome(s);
	System.out.println("Result: " + result);
    }
}
