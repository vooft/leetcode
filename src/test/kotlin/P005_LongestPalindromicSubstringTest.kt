import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class P005_LongestPalindromicSubstringTest {
    @Test
    fun `simple test 1`() {
        val string = "babad"

        val expected = "bab"
        val actual = P005_LongestPalindromicSubstring().longestPalindrome(string)

        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 2`() {
        val string = "cbbd"

        val expected = "bb"
        val actual = P005_LongestPalindromicSubstring().longestPalindrome(string)

        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 3`() {
        val string = "aacabdkacaa"

        val expected = "aca"
        val actual = P005_LongestPalindromicSubstring().longestPalindrome(string)

        assertEquals(expected, actual)
    }
}
