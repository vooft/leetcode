import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidParenthesesTest {
    @ParameterizedTest
    @ValueSource(strings = { "()", "()[]{}", "{[()]}", "{((()[]{}[[()(){{{[]}}}]]))}" })
    void should_accept_parentheses(String sequence) {
        ValidParentheses solution = new ValidParentheses();
        assertTrue(solution.isValid(sequence));
    }

    @ParameterizedTest
    @ValueSource(strings = { "())", "(){[}]", "()]}", "(((]]]{{{}}}" })
    void should_not_accept_parentheses(String sequence) {
        ValidParentheses solution = new ValidParentheses();
        assertFalse(solution.isValid(sequence));
    }
}
