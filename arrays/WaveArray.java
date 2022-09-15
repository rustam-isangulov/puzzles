package arrays;

import java.util.Arrays;

public class WaveArray {
    public static void main(String... args) {
	System.out.println();
	System.out.println("WaveArray is starting...");

	test(new int[]{1, 2, 3, 4, 5});
	test(new int[]{});
	test(new int[]{-1, -1, -1});

	System.out.println("WaveArray has finished.");
    }

    static void test(int[] input) {
	System.out.println("Input: " + Arrays.toString(input));

	var output = getWaveArray(input);

	System.out.println("Output: " + Arrays.toString(output));
	System.out.println();
    }

    static int[]  getWaveArray(int[] arr) {

	// sorted input array is expected
	// alternatively add Arrays.sort(arr);

	// input
	// a0 < a1 < a2 < a3 < a4 < a5

	// output
	// 0    1     2   3    4    5    6    7    8    9
	// a1 > a0 < a3 > a2 < a5 > a4 < a7 > a6 < a9 > a8

	int temp;

	for (int i = 1; i < arr.length; i= i*2 + 1) {
	    temp = arr[i];
	    arr[i] = arr[i-1];
	    arr[i-1] = temp;
	}

	return arr;
    }
}
