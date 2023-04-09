package strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.stream.Stream;

public class MultiplyStringsTest {
    private static final MultiplyStrings solution = new MultiplyStrings();

    @ParameterizedTest
    @MethodSource
    void test( String num1, String num2, String expectedOutput ) {
        System.out.println();
        System.out.printf("Input: num1: %s, num2: %s", num1, num2);
        System.out.println();

        var output = solution.multiply(num1, num2);

        System.out.println("Output: " + output);
        System.out.println();

        Assertions.assertEquals(expectedOutput, output);
    }

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of("0", "52", "0"),
                Arguments.of("2", "3", "6"),
                Arguments.of("20", "3", "60"),
                Arguments.of("500", "1", "500"),
                Arguments.of("123", "456", Integer.toString(123*456)),
                Arguments.of(
                        "123456789",
                        "987654321",
                        new BigInteger("123456789")
                                .multiply(new BigInteger("987654321")).toString()
                ),
                Arguments.of(
                        "123456789",
                        "123456789",
                        new BigInteger("123456789")
                                .multiply(new BigInteger("123456789")).toString()
                ),
                Arguments.of("000", "00", "0")
        );
    }
}
