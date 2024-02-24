package leetcode

import java.util.BitSet

/**
 * https://leetcode.com/problems/longest-valid-parentheses
 *
 * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed)
 * parentheses substring
 *
 * Example 1:
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 *
 * Example 2:
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 *
 * Example 3:
 * Input: s = ""
 * Output: 0
 *
 * Constraints:
 * 0 <= s.length <= 3 * 104
 * s[i] is '(', or ')'.
 */
class P032_LongestValidParentheses {
    fun longestValidParentheses(s: String): Int {
        // bit is set to true if there is a matching parentheses pair
        val hasMatching = BitSet()
        val stack = ArrayDeque<Int>()
        for (i in s.indices) {
            if (s[i] == '(') {
                stack.add(i)
            } else {
                val pop = stack.removeLastOrNull()
                if (pop != null) {
                    hasMatching.set(pop)
                    hasMatching.set(i)
                }
            }
        }

        // then just find the longest sequence of set bits
        var max = 0
        var current = 0
        for (i in 0..hasMatching.length()) {
            if (hasMatching.get(i)) {
                current++
            } else {
                if (max < current) {
                    max = current
                }

                current = 0
            }
        }

        return max
    }
}
