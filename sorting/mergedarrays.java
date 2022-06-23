package sorting;

import java.util.*;

/*
tag: sorting

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109
*/

public class mergedarrays {
    public static void main(String... args) {

	abstract class Runner { abstract void run(); }

	Runner ex1 = new Runner() {
		int[] nums1 = new int[]{1, 2, 3, 4, 0, 0, 0};
		int[] nums2 = new int[]{2,5,6};

		public void run() {
		    System.out.println("nums1: " + Arrays.toString(nums1));
		    System.out.println("nums2: " + Arrays.toString(nums2));

		    merge(nums1, 3, nums2, 3);
		    // iterateAndReaplce(nums1, 4, nums2, 3);

		    System.out.println("result: " + Arrays.toString(nums1));
		}
	    };

	Runner ex2 = new Runner() {
		int[] nums1 = new int[]{1};
		int[] nums2 = new int[0];

		public void run() {
		    System.out.println("nums1: " + Arrays.toString(nums1));
		    System.out.println("nums2: " + Arrays.toString(nums2));

		    merge(nums1, 1, nums2, 0);
		    // iterateAndReaplce(nums1, 1, nums2, 0);

		    System.out.println("result: " + Arrays.toString(nums1));
		}
	    };

	Runner ex3 = new Runner() {
		int[] nums1 = new int[]{0};
		int[] nums2 = new int[]{1};

		public void run() {
		    System.out.println("nums1: " + Arrays.toString(nums1));
		    System.out.println("nums2: " + Arrays.toString(nums2));

		    merge(nums1, 0, nums2, 1);

		    System.out.println("result: " + Arrays.toString(nums1));
		}
	    };

	Runner ex4 = new Runner() {
		int[] nums1 = new int[]{-1, 0, 0, 1, 2, 3, 0, 0, 0};
		int[] nums2 = new int[]{-2,5,6};

		public void run() {
		    System.out.println("nums1: " + Arrays.toString(nums1));
		    System.out.println("nums2: " + Arrays.toString(nums2));

		    merge(nums1, 6, nums2, 3);

		    System.out.println("result: " + Arrays.toString(nums1));
		}
	    };

	Runner ex5 = new Runner() {
		int[] nums1 = new int[]{1, 2, 4, 5, 6, 0, 0};
		int[] nums2 = new int[]{3, 5};

		public void run() {
		    System.out.println("nums1: " + Arrays.toString(nums1));
		    System.out.println("nums2: " + Arrays.toString(nums2));

		    merge(nums1, 5, nums2, 2);

		    System.out.println("result: " + Arrays.toString(nums1));
		}
	    };

	ex1.run();
	System.out.println();
	ex2.run();
	System.out.println();
	ex3.run();
	System.out.println();
	ex4.run();
	System.out.println();
	ex5.run();
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
	// index after which everything is merged
	int aIndexEnd = m+n-1;
	// index of the last unmerged value in nums1
	int aIndexValue = m-1;
	// go backwards through nums2 and move merged values to the right
	for(int i = n-1; i >= 0; i--) {
	    while ((aIndexValue >= 0) && nums1[aIndexValue] > nums2[i]) {
		nums1[aIndexEnd--] = nums1[aIndexValue--];
	    }

	    nums1[aIndexEnd--] = nums2[i];
	}
    }

    public static void iterateAndReaplce(int[] a, int m, int[] b, int n) {
	// index of the head element of the queue
	int holdIndexFirst = -1;
	// index of the tail element of queue
	int holdIndexLast = -1;
	// storage for hold queue
	// we do noit shrink the underlying structure
	// therfore it is as long as m
	int[] hold = new int[m];
	// index of the head of the queue
	int bIndexFirst = 0;

	// basic checks
	if(n==0) return;

	// iterate though first m elements and reaplce if necessary
	for (int i = 0; i < m; i++) {
	    System.out.println("a[" + i + "] = " + a[i]);

	    if (holdIndexFirst < 0) {
		if (b[bIndexFirst] < a[i]) {
		    hold[++holdIndexLast] = a[i];
		    holdIndexFirst++;
		    a[i] = b[bIndexFirst++];
		}
	    } else {
		if ((bIndexFirst < n) && b[bIndexFirst] < hold[holdIndexFirst]) {
		    if (b[bIndexFirst] < a[i]) {
			hold[++holdIndexLast] = a[i];
			a[i] = b[bIndexFirst++];
		    }
		} else {
		    if (hold[holdIndexFirst] < a[i]) {
			hold[++holdIndexLast] = a[i];
			a[i] = hold[holdIndexFirst++];
		    }
		}
	    }
	}

	// iterate through the n 0's at the back of array a and fill
	// it with what is left in b and hold
	for (int i = m; i < m+n; i++) {
	    if ( holdIndexFirst < 0) {
		a[i] = b[bIndexFirst++];
	    } else {
		// compare add move
		if (holdIndexFirst <= holdIndexLast){
		    // have a value available in hold
		    if (bIndexFirst < n) {
			// have a value available in b
			if (b[bIndexFirst] < hold[holdIndexFirst]) {
			    a[i] = b[bIndexFirst++];
			} else {
			    a[i] = hold[holdIndexFirst++];
			}
		    } else {
			// no values available in b
			a[i] = hold[holdIndexFirst++];
		    }
		} else {
		    // no values available in hold
		    a[i] = b[bIndexFirst++];
		}
	    }
	}
    }
}
