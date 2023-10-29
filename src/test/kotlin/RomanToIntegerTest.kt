import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class RomanToIntegerTest {
    @ParameterizedTest
    @CsvSource("III,3", "LVIII,58", "MCMXCIV,1994", "MDCCLXXVI,1776", "I,1", "II,2", "MDCXCV,1695")
    fun should_parse_roman_number(romanNumber: String?, number: Int) {
        val romanToInteger = RomanToInteger()
        Assertions.assertEquals(number, romanToInteger.romanToInt(romanNumber!!))
    }
}
