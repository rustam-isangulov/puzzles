package matrix;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

public class SpiralOrder {
    public List<Integer> spiralOrder( int[][] matrix ) {
        List<Integer> result = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int outputLenth = m * n;

        int minCol = 0;
        int maxCol = n - 1;
        int minRow = 0;
        int maxRow = m - 1;
        int incrementCol = 1;
        int incrementRow = 0;

        int currentRow = minRow;
        int currentCol = minCol;


        for (int i = 0; i < outputLenth; i++) {

            result.add(matrix[currentRow][currentCol]);

            currentCol = currentCol + incrementCol;
            currentRow = currentRow + incrementRow;

            if (currentCol > maxCol) {
                // move right - hit the wall

                currentCol--;
                incrementCol = 0;
                incrementRow = 1;

                currentRow = currentRow + incrementRow;
                minRow++;

            } else if (currentRow > maxRow) {
                // move down - hit the floor

                currentRow--;
                incrementCol = -1;
                incrementRow = 0;

                currentCol = currentCol + incrementCol;
                maxCol--;

            } else if (currentCol < minCol) {
                // move left - hit the wall

                currentCol++;
                incrementCol = 0;
                incrementRow = -1;

                currentRow += incrementRow;
                maxRow--;

            } else if (currentRow < minRow) {
                // move up - hit the ceiling

                currentRow++;
                incrementCol = 1;
                incrementRow = 0;

                currentCol += incrementCol;
                minCol++;

            }
        }

        return result;
    }
}
