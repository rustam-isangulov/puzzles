package math;

import java.util.Set;
import java.util.HashSet;

public class HappyNumber {
    public static void main(String... args) {
	System.out.println("Happy number is starting...");

	test(2);
	test(19);
	test(42);
	test(301);

	System.out.println("Happy number has finished.");
    }

    public static void test(int n) {
	System.out.println();
	System.out.println("Input: n = " + n);

	var output = isHappy(n);

	System.out.println("Output: " + output);
	System.out.println();
    }

    public static boolean isHappy(int n) {
	var result = true;

	int[] digits = new int[31];
	int numOfDigits;
	int r;
	Set<Integer> prevN = new HashSet<>();

	while ( n > 1) {

	    numOfDigits = 0;

	    while ( n > 0 ) {
		r = n % 10;
		digits[numOfDigits++] = r;
		n = n / 10;
	    }

	    n = 0;

	    for (int k = 0; k < numOfDigits; k++) {
		n = n + digits[k]*digits[k];
	    }

	    if (!prevN.add(n)) {
		result = false;
		break;
	    }
	}

	return result;
    }
}
