package search;

import java.util.*;
import java.util.stream.*;

/**
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

public class MaxProfit {
    public static void main(String... args) {
	System.out.println("MaxProfit is starting...");

	Test(new int[]{1,2,0});
	Test(new int[]{2});
	Test(new int[]{2,1,2,0,1});
	Test(new int[]{7,1,5,3,6,4});
	Test(new int[]{7,6,4,3,1});
	Test(new int[]{7,2,5,0,6,4});
	Test(new int[]{0});
	Test(new int[]{0,0,0,0});
    }


    static int maxProfit(int[] prices){
	int maxProfit = 0;
	int maxRight = 0;

	for(int i = prices.length - 1; i >= 0; i--) {
	    if (prices[i] > maxRight)
		maxRight = prices[i];
	    if (maxRight - prices[i] > maxProfit)
		maxProfit = maxRight - prices[i];
	}

	return maxProfit;
    }


    static void Test(int[] prices) {
	System.out.println();
	System.out.println("Input array: " + Arrays.toString(prices));
	int result = maxProfit(prices);
	System.out.println("Result: " + result);
    }
}
