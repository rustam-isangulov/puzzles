package arrays;

import java.util.Arrays;

public class WaveArray {
    public int[] getWaveArray( int[] arr ) {

        // sorted input array is expected
        // alternatively add Arrays.sort(arr);

        // input
        // a0 < a1 < a2 < a3 < a4 < a5

        // output
        // 0    1     2   3    4    5    6    7    8    9
        // a1 > a0 < a3 > a2 < a5 > a4 < a7 > a6 < a9 > a8

        int[] result = Arrays.copyOf(arr, arr.length);

        for (int i = 1; i < arr.length; i = i * 2 + 1) {
            result[i] = arr[i - 1];
            result[i - 1] = arr[i];
        }

        return result;
    }
}
