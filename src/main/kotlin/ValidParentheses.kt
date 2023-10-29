import java.util.Arrays
import java.util.LinkedList
import java.util.function.Function
import java.util.stream.Collectors

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */
class ValidParentheses {
    internal enum class Bracket(val open: Char, val close: Char) {
        CURLY('{', '}'),
        ROUND('(', ')'),
        SQUARE('[', ']')
    }

    private val opens = Arrays.stream(Bracket.entries.toTypedArray())
        .collect(Collectors.toMap(Function { it: Bracket -> it.open }, Function.identity()))
    private val closes = Arrays.stream(Bracket.entries.toTypedArray())
        .collect(Collectors.toMap(Function { it: Bracket -> it.close }, Function.identity()))

    fun isValid(s: String): Boolean {
        val stack = LinkedList<Bracket>()
        for (i in 0 until s.length) {
            val c = s[i]
            val openBracket = opens[c]
            if (openBracket != null) {
                stack.push(openBracket)
            } else {
                val closeBracket = closes[c]
                if (stack.isEmpty() || stack.pop() != closeBracket) {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }
}
