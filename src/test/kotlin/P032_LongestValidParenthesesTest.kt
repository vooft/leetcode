import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class P032_LongestValidParenthesesTest {
    @Test
    fun `simple positive test 1`() {
        val string = "(()"
        val expected = 2
        val actual = P032_LongestValidParentheses().longestValidParentheses(string)

        actual shouldBe expected
    }

    @Test
    fun `simple positive test 2`() {
        val string = ")()())"
        val expected = 4
        val actual = P032_LongestValidParentheses().longestValidParentheses(string)

        actual shouldBe expected
    }

    @Test
    fun `simple negative test 3`() {
        val string = ""
        val expected = 0
        val actual = P032_LongestValidParentheses().longestValidParentheses(string)

        actual shouldBe expected
    }

    @Test
    fun `simple positive test 4`() {
        val string = "()()()()"
        val expected = 8
        val actual = P032_LongestValidParentheses().longestValidParentheses(string)

        actual shouldBe expected
    }
}
