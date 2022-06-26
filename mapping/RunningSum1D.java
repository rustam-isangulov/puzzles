package mapping;

import java.util.*;
import java.util.stream.*;

public class RunningSum1D {
    public static void main(String... args) {
	System.out.println("RunningSum1D is starting...");

	TestCase
	    .of(new int[] {1, 2, 3, 4})
	    .run();

	TestCase
	    .of(new int[] {2})
	    .run();

	TestCase
	    .of(new int[] {})
	    .run();
    }

    public static int[] runningSum(int[] nums) {
	if (nums.length > 1) {
	    for(int i = 1; i < nums.length; i++) {
		nums[i] = nums[i] + nums[i-1];
	    }
	}

	return nums;

	// iteration: 2

	// for(int i = 0; i < nums.length; i++) {
	//     result[i] = Arrays.stream(nums,0,i+1).sum();
	// }

	// return result;

	// iteration: 1

	// return IntStream
	//     .rangeClosed(1, nums.length)
	//     .map(n->Arrays.stream(nums,0,n).sum())
	//     .toArray();
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
	    int[] result = runningSum(nums);
	    System.out.println("Result: " + Arrays.toString(result));
	}
    }
}
