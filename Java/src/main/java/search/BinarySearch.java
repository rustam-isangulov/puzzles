package search;

import java.util.*;

/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 */

public class BinarySearch {
    public int search( int[] nums, int target ) {
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
}
