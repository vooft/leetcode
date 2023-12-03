
import java.util.LinkedList

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 * * Open brackets must be closed by the same type of brackets.
 * * Open brackets must be closed in the correct order.
 * * Note that an empty string is also considered valid.
 *
 * Example 1:
 * Input: "()"
 * Output: true
 *
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: "(]"
 * Output: false
 *
 * Example 4:
 * Input: "([)]"
 * Output: false
 *
 * Example 5:
 * Input: "{[]}"
 * Output: true
 */
class P020_ValidParentheses {
    internal enum class Bracket(val open: Char, val close: Char) {
        CURLY('{', '}'),
        ROUND('(', ')'),
        SQUARE('[', ']')
    }

    private val opens = Bracket.entries.associateBy { it.open }
    private val closes = Bracket.entries.associateBy { it.close }

    fun isValid(s: String): Boolean {
        val stack = LinkedList<Bracket>()
        for (element in s) {
            val openBracket = opens[element]
            if (openBracket != null) {
                stack.push(openBracket)
            } else {
                val closeBracket = closes[element]
                if (stack.isEmpty() || stack.pop() != closeBracket) {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }
}
