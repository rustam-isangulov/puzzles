package strings;

import java.util.*;
import java.util.stream.*;

/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 */

public class Isomorphic {
    public static void main(String... args) {
	System.out.println("Isomorphic is starting...");

	TestCase.of("egg", "add").run();
	TestCase.of("foo", "bar").run();
	TestCase.of("paper", "title").run();
	TestCase.of("badc", "baba").run();
    }


    static boolean isIsomorphic(String s, String t) {
	boolean result = true;

	Map<Integer,Integer> map = new HashMap<>();

	// iteration #1
	for(int i = 0; i < s.length(); i++ ) {
	    var c1 = Integer.valueOf(s.codePointAt(i));
	    var c2 = Integer.valueOf(t.codePointAt(i));

	    if (map.containsKey(c1)) {
		if (map.get(c1) != c2) {
		    result = false;
		    break;
		}
	    } else {
		// No two characters may map to the same character
		if (map.containsValue(c2)) {
		    result = false;
		    break;
		} else {
		    map.put(c1, c2);
		}
	    }
	}

	return result;
    }


    static class TestCase {
	private String s;
	private String t;

	TestCase(String s, String t) {
	    this.s = s;
	    this.t = t;
	}

	static TestCase of(String s, String t) {
	    return new TestCase(s, t);
	}

	void run() {
	    System.out.println();
	    System.out.println("Input s: [" + s + "] t: [" + t + "]") ;
	    boolean result = isIsomorphic(s, t);
	    System.out.println("Result: " + result);
	}
    }
}
