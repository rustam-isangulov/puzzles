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

public class MergedArrays {
    public void merge( int[] nums1, int m, int[] nums2, int n ) {
        // index after which everything is merged
        int aIndexEnd = m + n - 1;
        // index of the last unmerged value in nums1
        int aIndexValue = m - 1;
        // go backwards through nums2 and move merged values to the right
        for (int i = n - 1; i >= 0; i--) {
            while ((aIndexValue >= 0) && nums1[aIndexValue] > nums2[i]) {
                nums1[aIndexEnd--] = nums1[aIndexValue--];
            }

            nums1[aIndexEnd--] = nums2[i];
        }
    }
}
