package search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class MaxProfitTest {
    private static final MaxProfit solution = new MaxProfit();

    @ParameterizedTest( name = "({index}) stock prices: {0}, expected profit: [{1}]")
    @MethodSource
    void test( int[] prices, int expectedOutput ) {
        int result = solution.maxProfit(prices);
        Assertions.assertEquals(expectedOutput, result);
    }

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 0}, 1),
                Arguments.of(new int[]{2,1,2,0,1}, 1),
                Arguments.of(new int[]{7,1,5,3,6,4}, 5),
                Arguments.of(new int[]{7,6,4,3,1}, 0),
                Arguments.of(new int[]{0, 0, 0, 0}, 0),
                Arguments.of(new int[]{0}, 0),
                Arguments.of(null, 0),
                Arguments.of(new int[]{2}, 0)
        );
    }
}
