package search;

import java.util.*;
import java.util.stream.*;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

public class MaxProfit {
    public int maxProfit( int[] prices ) {
        // basic check
        if (prices == null) return 0;

        int maxProfit = 0;
        int maxRight = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > maxRight)
                maxRight = prices[i];
            if (maxRight - prices[i] > maxProfit)
                maxProfit = maxRight - prices[i];
        }

        return maxProfit;
    }
}
