package search;

/**
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */

public class FirstBadVersion {
    static int firstBadVersion = 1;

    public static void main(String... args) {
	System.out.println("FirstBadVersion is starting...");

	firstBadVersion = 7;
	Test(7);

	firstBadVersion = 2147483644;
	Test(2147483647);
    }


    public static int firstBadVersion(int n) {
	long L = 0;
	long R = n;
	long next = 0;

	while (R - L > 1) {
	    next = (R - L + 1) / 2 + L;

	    if (!isBadVersion((int)next)) {
		L = next;
	    } else {
		R = next;
	    }
	}

	return (int)R;
    }


    public static boolean isBadVersion(int version) {
	return version >= firstBadVersion ? true : false;
    }


    static void Test(int n) {
	System.out.println();
	System.out.println("Input: " + n);
	int result = firstBadVersion(n);
	System.out.println("Result: " + result);
    }
}
