import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class P022_GenerateParenthesesTest {

    @Test
    fun `simplest test 1`() {
        val expected = arrayOf("()")
        val actual = P022_GenerateParentheses().generateParenthesis(1)
        println(actual)

        assertThat(actual).containsExactlyInAnyOrder(*expected)
    }

    @Test
    fun `simple test 2`() {
        val expected = arrayOf("(())","()()")
        val actual = P022_GenerateParentheses().generateParenthesis(2)
        println(actual)

        assertThat(actual).containsExactlyInAnyOrder(*expected)
    }

    @Test
    fun `simple test 3`() {
        val expected = arrayOf("((()))","(()())","(())()","()(())","()()()")
        val actual = P022_GenerateParentheses().generateParenthesis(3)
        println(actual)

        assertThat(actual).containsExactlyInAnyOrder(*expected)
    }
}
