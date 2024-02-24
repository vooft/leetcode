package leetcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class P409_LongestPalindromeTest {
    @Test
    fun `simple test 1`() {
        val string = "abccccdd"
        val expected = 7

        val actual = P409_LongestPalindrome().longestPalindrome(string)

        actual shouldBe expected
    }

    @Test
    fun `simple test 2`() {
        val string = "a"
        val expected = 1

        val actual = P409_LongestPalindrome().longestPalindrome(string)

        actual shouldBe expected
    }
}
