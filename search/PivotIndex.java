package search;

import java.util.*;

/*
Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.
 */

public class PivotIndex {
    public static void main(String... args) {
	System.out.println("PivotIndex is starting...");

	TestCase.of( new int[]{1, 7, 3, 6, 5, 6}).run();
	TestCase.of( new int[]{1, 2, 3}).run();
	TestCase.of( new int[]{0}).run();
	TestCase.of( new int[]{2, 1, -1}).run();
	TestCase.of( new int[]{2, -2, -1}).run();
    }


    static int pivotIndex(int[] nums) {
	int sumLeft = 0;

	Map<Integer, Integer> map = new HashMap<>();

	map.put(nums[0], 0);

	for(int i = 1; i < nums.length; i++) {
	    sumLeft += nums[i-1];
	    map.putIfAbsent(2*sumLeft + nums[i], i);
	}

	final int totalSum = sumLeft + nums[nums.length-1];

	return map.getOrDefault(totalSum, -1);

	// iteration #2

	/* int sumLeft = 0; */
	/* Map<Integer, Integer> map = new HashMap<>(); */

	/* map.put(0, sumLeft); */

	/* for(int i = 1; i < nums.length; i++) { */
	/*     sumLeft = sumLeft + nums[i-1]; */
	/*     map.put(i, sumLeft); */
	/* } */

	/* final int totalSum = sumLeft + nums[nums.length-1]; */

	/* return  map.entrySet().stream() */
	/*     .filter(entry -> */
	/* 	    totalSum == nums[entry.getKey()] + 2 * entry.getValue()) */
	/*     .findFirst().map(Map.Entry::getKey).orElse(-1); */


	// iteration #1

	// var sum = Arrays.stream(nums).sum();
	// System.out.println("sum: " + sum);

	// int sumLeft = 0;

	// for(int i = 0; i < nums.length; i++) {
	//     sumLeft = Arrays.stream(nums, 0, i).sum();
	//     System.out.println("[" + i + "] sumLeft: " + sumLeft + " sumRight: " + (sum - nums[i] - sumLeft));

	//     if (sumLeft == (sum - nums[i] - sumLeft)) {
	// 	result = i;
	// 	break;
	//     }
	// }

    }


    static class TestCase {
	private int[] nums;

	TestCase(int[] nums) {
	    this.nums = nums;
	}

	static TestCase of(int[] nums) {
	    return new TestCase(nums);
	}

	void run() {
	    System.out.println();
	    System.out.println("Input array: " + Arrays.toString(nums));
	    int result = pivotIndex(nums);
	    System.out.println("Result: " + result);
	}
    }

}
