package search;

import java.util.function.Predicate;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */

public class FirstBadVersion {
    public int findBadVersion( int totalNumberOfVersions, Predicate<Integer> apiIsBadVersion ) {
        long L = 0;
        long R = totalNumberOfVersions;
        long next = 0;

        while (R - L > 1) {
            next = (R - L + 1) / 2 + L;

            if (!apiIsBadVersion.test((int) next)) {
                L = next;
            } else {
                R = next;
            }
        }

        return (int) R;
    }
}
