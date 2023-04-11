package aainterviewprep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class StringToIntegerTest {

    @Test
    void testNullException() {
        String badCharacterInteger = null;
        Exception ex = Assertions.assertThrows(
                NumberFormatException.class,
                () -> StringToInteger.toInt(badCharacterInteger)
        );
        Assertions.assertEquals(
                "String is not an integer! String is null.",
                ex.getMessage()
        );
    }

    @Test
    void testTooBigException() {
        String badCharacterInteger = "2147483649";
        Exception ex = Assertions.assertThrows(
                NumberFormatException.class,
                () -> StringToInteger.toInt(badCharacterInteger)
        );
        Assertions.assertEquals(
                "String is not an integer! Number is out of range.",
                ex.getMessage()
        );
    }

    @Test
    void testBadCharacterException() {
        String badCharacterInteger = "-12k4";
        Exception ex = Assertions.assertThrows(
                NumberFormatException.class,
                () -> StringToInteger.toInt(badCharacterInteger)
        );
        Assertions.assertEquals(
                "String is not an integer! Bad character at pos [3]",
                ex.getMessage()
        );
    }

    @ParameterizedTest
    @MethodSource
    void testNumbers( String input, Integer expectedOutput ) {
        Integer result = StringToInteger.toInt(input);
        Assertions.assertEquals(expectedOutput, result);
    }

    public static Stream<Arguments> testNumbers() {
        return Stream.of(
                Arguments.of("-1234", -1234),
                Arguments.of("1234", 1234),
                Arguments.of("0", 0),
                Arguments.of("-0", 0)
        );
    }
}
