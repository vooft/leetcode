import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ValidParenthesesTest {
    @ParameterizedTest
    @ValueSource(strings = ["()", "()[]{}", "{[()]}", "{((()[]{}[[()(){{{[]}}}]]))}"])
    fun should_accept_parentheses(sequence: String?) {
        val solution = ValidParentheses()
        Assertions.assertTrue(solution.isValid(sequence!!))
    }

    @ParameterizedTest
    @ValueSource(strings = ["())", "(){[}]", "()]}", "(((]]]{{{}}}"])
    fun should_not_accept_parentheses(sequence: String?) {
        val solution = ValidParentheses()
        Assertions.assertFalse(solution.isValid(sequence!!))
    }
}
