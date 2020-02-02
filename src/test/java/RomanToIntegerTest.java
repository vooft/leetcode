import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanToIntegerTest {
    @ParameterizedTest
    @CsvSource({"III,3", "LVIII,58", "MCMXCIV,1994", "MDCCLXXVI,1776", "I,1", "II,2", "MDCXCV,1695"})
    public void should_parse_roman_number(String romanNumber, int number) {
        RomanToInteger romanToInteger = new RomanToInteger();
        assertEquals(number, romanToInteger.romanToInt(romanNumber));
    }
}
