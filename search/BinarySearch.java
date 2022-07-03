package search;

import java.util.*;

/**
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.
 */

public class BinarySearch {
    public static void main(String... args) {
	System.out.println("BinarySearch is starting...");

	Test(null, 9);
	Test(new int[] {4}, 4);
	Test(new int[] {-100, 400, 1000}, 500);
	Test(new int[]{-1,0,3,5,9,12}, 9);
    }

    public static int search(int[] nums, int target) {
	// basic check
	if (nums == null) return -1;

	int L = -1;
	int R = nums.length - 1;
	int next = 0;

	while (R - L > 1) {
	    next = (R - L + 1) / 2 + L;

	    if (target > nums[next]) {
		L = next;
	    } else {
		R = next;
	    }
	}

	return target == nums[R] ? R : -1;
    }


    static void Test(int[] nums, int target) {
	System.out.println();
	System.out.println("Input array: " + Arrays.toString(nums));
	System.out.println("Target: " + target);
	int result = search(nums, target);
	System.out.println("Result: " + result);
    }
}
