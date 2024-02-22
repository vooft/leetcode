/**
 * https://leetcode.com/problems/generate-parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 */
class P022_GenerateParentheses {
    fun generateParenthesis(n: Int): List<String> {
        if (n == 1) {
            return listOf("()")
        }

        return (1..<n).fold(listOf("()")) { acc, _ ->
            generateParentheses(acc)
        }
    }

    private fun generateParentheses(previous: List<String>): List<String> {
        return buildSet {
            for (variant in previous) {
                for (i in variant.indices) {
                    add("${variant.substring(0, i + 1)}()${variant.substring(i + 1)}")
                }
            }
        }.toList()
    }
}
