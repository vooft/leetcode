import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeNumberTest {

    @ParameterizedTest
    @ValueSource(ints = { 12321, 123321, 121, 333, 22, 1, 999999999 })
    void should_accept_palindrome(int value) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        assertTrue(palindromeNumber.isPalindrome(value));
    }

    @ParameterizedTest
    @ValueSource(ints = { -1, -99999, 123, 321, 123456789, Integer.MAX_VALUE, Integer.MIN_VALUE })
    void should_not_accept_palindrome(int value) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        assertFalse(palindromeNumber.isPalindrome(value));
    }
}
