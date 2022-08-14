package matrix;

import java.util.Arrays;

/*
You have a 2-D grid of size m x n representing a box, and you have n balls. The box is open on the top and bottom sides.

Each cell in the box has a diagonal board spanning two corners of the cell that can redirect a ball to the right or to the left.

A board that redirects the ball to the right spans the top-left corner to the bottom-right corner and is represented in the grid as 1.
A board that redirects the ball to the left spans the top-right corner to the bottom-left corner and is represented in the grid as -1.
We drop one ball at the top of each column of the box. Each ball can get stuck in the box or fall out of the bottom. A ball gets stuck if it hits a "V" shaped pattern between two boards or if a board redirects the ball into either wall of the box.

Return an array answer of size n where answer[i] is the column that the ball falls out of at the bottom after dropping the ball from the ith column at the top, or -1 if the ball gets stuck in the box.
 */

public class FindBall {
    public static void main(String... args) {
	System.out.println("FindBall is starting...");

	test(new int[][]{ {1,1,1,-1,-1}
			 ,{1,1,1,-1,-1}
			 ,{-1,-1,-1,1,1}
			 ,{1,1,1,1,-1}
			 ,{-1,-1,-1,-1,-1}});

	test(new int[][]{ {1,1,1,1,1,1}
			 ,{-1,-1,-1,-1,-1,-1}
			 ,{1,1,1,1,1,1}
			 ,{-1,-1,-1,-1,-1,-1}});

	test(new int[][]{{-1}});

	test(new int[][]{{1}});

	test(new int[][]{ {1,-1,-1,1,-1,1,1,1,1,1,-1,1,1,1,1,1,1,-1,-1,-1,-1,-1,-1,1,-1,1,-1,1,-1,-1,-1,-1,1,-1,1,1,-1,-1,-1,-1,-1,1}
			 ,{-1,1,1,1,-1,-1,-1,-1,1,1,1,-1,-1,-1,1,-1,-1,1,1,1,1,1,1,-1,1,-1,-1,-1,-1,-1,1,-1,1,-1,-1,-1,-1,1,1,-1,1,1}
			 ,{1,-1,-1,-1,-1,1,-1,1,1,1,1,1,1,1,-1,1,-1,-1,-1,1,-1,-1,1,-1,1,-1,1,-1,-1,1,-1,1,-1,1,1,-1,-1,1,1,-1,1,-1}});

	System.out.println("FindBall has finished.");
    }

    public static void test(int[][] grid) {
	System.out.println("Input: grid = ");

	for (int row = 0; row < grid.length; row++) {
	    System.out.println(Arrays.toString(grid[row]));
	}

	var output = findBall(grid);

	System.out.println("Output array: ");
	System.out.println(Arrays.toString(output));
	System.out.println();
    }

    public static int[] findBall(int[][] grid) {
	int[] result = new int[grid[0].length];

	int m = grid.length;
	int n = grid[0].length;

	for (int j = 0; j < n; j++) {
	    result[j] = -1;
	    int e = j;

	    for (int i = 0; i < m; i++) {
		if (grid[i][e] == 1) {
		    if ((e+1 == n) || (grid[i][e+1] == -1)) {
			break;
		    } else {
			e++;

			if (i == (m - 1)) {
			    result[j] = e;
			}
		    }
		} else {
		    if ((e == 0) || (grid[i][e-1] == 1)) {
			break;
		    } else {
			e--;

			if (i == (m - 1)) {
			    result[j] = e;
			}
		    }
		}
	    }
	}

	return result;
    }
}
