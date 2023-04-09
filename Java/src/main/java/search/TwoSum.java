package search;

/*
tag: search

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
*/

public class TwoSum {
    public int[] twoSum( int[] nums, final int target ) {
        int[] ret = new int[]{-1, -1};
        int complement = 0;
        int numsLength = nums.length;

        top:
        for (int i = 0; i < numsLength - 1; i++) {
            complement = target - nums[i];
            for (int j = i + 1; j < numsLength; j++) {
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
