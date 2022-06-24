package search;

import java.util.*;

/*
tag: search

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
*/

public class twosum {
    public static void main(String... args) {
	System.out.println("twosum is starting... ");
	System.out.println();

	class Runner { void run(){} }

	Runner ex1 = new Runner() {
		int[] nums = new int[]{2, 7, 11, 15};
		int target = 9;

		void run() {
		    System.out.println("nums: " + Arrays.toString(nums));
		    System.out.println("target: " + target);

		    int[] indices = twoSum(nums, target);

		    System.out.println("result: " + Arrays.toString(indices));
		}
	    };

	Runner ex2 = new Runner() {
		int[] nums = new int[]{3, 2, 4};
		int target = 6;

		void run() {
		    System.out.println("nums: " + Arrays.toString(nums));
		    System.out.println("target: " + target);

		    int[] indices = twoSum(nums, target);

		    System.out.println("result: " + Arrays.toString(indices));
		}
	    };

	Runner ex3 = new Runner() {
		int[] nums = new int[]{3, 3};
		int target = 6;

		void run() {
		    System.out.println("nums: " + Arrays.toString(nums));
		    System.out.println("target: " + target);

		    int[] indices = twoSum(nums, target);

		    System.out.println("result: " + Arrays.toString(indices));
		}
	    };

	Runner ex4 = new Runner() {
		int[] nums = new int[]{0, 3, 4, 0};
		int target = 0;

		void run() {
		    System.out.println("nums: " + Arrays.toString(nums));
		    System.out.println("target: " + target);

		    int[] indices = twoSum(nums, target);

		    System.out.println("result: " + Arrays.toString(indices));
		}
	    };

	ex1.run();

	System.out.println();
	ex2.run();

    	System.out.println();
	ex3.run();

	System.out.println();
	ex4.run();
    }

    public static int[] twoSum(int[] nums, final int target) {
	int[] ret = new int[]{-1,-1};
	int complement = 0;
	int numsLength = nums.length;

	top:
	for(int i = 0; i < numsLength-1;i++) {
	    complement = target - nums[i];
	    for(int j = i+1; j < numsLength; j++) {
		if (complement == nums[j]) {
		    ret[0] = i;
		    ret[1] = j;
		    break top;
		}
	    }
	}

	return ret;
    }
}
