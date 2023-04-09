package mapping;

import java.util.*;

public class RunningSum1D {
    public int[] runningSum( int[] nums ) {
        var result = Arrays.copyOf(nums, nums.length);

        if (result.length > 1) {
            for (int i = 1; i < result.length; i++) {
                result[i] = result[i] + result[i - 1];
            }
        }

        return result;

        // iteration: 2

        // for(int i = 0; i < nums.length; i++) {
        //     result[i] = Arrays.stream(nums,0,i+1).sum();
        // }

        // iteration: 1

        // return IntStream
        //     .rangeClosed(1, nums.length)
        //     .map(n->Arrays.stream(nums,0,n).sum())
        //     .toArray();
    }
}
