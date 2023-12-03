import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class P009_PalindromeNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [12321, 123321, 121, 333, 22, 1, 999999999])
    fun should_accept_palindrome(value: Int) {
        val palindromeNumber = P009_PalindromeNumber()
        Assertions.assertTrue(palindromeNumber.isPalindrome(value))
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, -99999, 123, 321, 123456789, Int.MAX_VALUE, Int.MIN_VALUE])
    fun should_not_accept_palindrome(value: Int) {
        val palindromeNumber = P009_PalindromeNumber()
        Assertions.assertFalse(palindromeNumber.isPalindrome(value))
    }
}
