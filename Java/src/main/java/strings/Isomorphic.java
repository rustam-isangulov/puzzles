package strings;

import java.util.*;
import java.util.stream.*;

/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 */

public class Isomorphic {
    public boolean isIsomorphic( String s, String t ) {
        boolean result = true;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            var c1 = Integer.valueOf(s.codePointAt(i));
            var c2 = Integer.valueOf(t.codePointAt(i));

            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            }

            if (!map.containsKey(c1) && map.containsValue(c2)) {
                return false;
            }

            map.put(c1, c2);
        }

        return result;
    }
}
