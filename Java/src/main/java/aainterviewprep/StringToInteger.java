package aainterviewprep;

import java.util.stream.IntStream;

public class StringToInteger {
    public static int toInt( String input ) {
        // null check
        if (null == input) {
            throw new NumberFormatException(
                    "String is not an integer! String is null."
            );
        }

        // sign
        int startDigits = 0;
        int signMultiplier = 1;
        if (input.startsWith("+")) {
            startDigits = 1;
        }
        if (input.startsWith("-")) {
            startDigits = 1;
            signMultiplier = -1;
        }

        if (input.length() - startDigits < 1) {
            throw new NumberFormatException(
                    "String is not an integer! No digits are present."
            );
        }

        // digits
        double result = IntStream.iterate(input.length() - 1, i -> i - 1)
                .limit(input.length() - startDigits)
                .mapToDouble(i -> {
                            int digit = input.charAt(i) - '0';
                            if (digit < 0 || digit > 9) {
                                throw new NumberFormatException(
                                        "String is not an integer! Bad character at pos ["
                                                + i + "]"
                                );
                            }
                            return digit * ((int) Math.pow(10, input.length() - i - 1));
                        }
                )
                .sum();

        // overflow
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new NumberFormatException(
                    "String is not an integer! Number is out of range."
            );
        }

        return (int) result * signMultiplier;
    }
}
