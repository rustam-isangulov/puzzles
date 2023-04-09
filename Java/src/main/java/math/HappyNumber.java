package math;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy( int n ) {
        var result = true;

        int[] digits = new int[31];
        Set<Integer> previousSquares = new HashSet<>();

        while (n > 1) {
            var numOfDigits = 0;
            var orderNumber = n;
            while (orderNumber > 0) {
                digits[numOfDigits++] = orderNumber % 10;
                orderNumber = orderNumber / 10;
            }

            var squareOfDigits = Arrays
                    .stream(digits, 0, numOfDigits)
                    .map(d -> d * d)
                    .sum();

            if (!previousSquares.add(squareOfDigits)) {
                return false;
            }

            n = squareOfDigits;
        }

        return result;
    }
}
