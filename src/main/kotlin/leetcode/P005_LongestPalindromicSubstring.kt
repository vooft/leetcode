package leetcode

/**
 * https://leetcode.com/problems/longest-palindromic-substring
 *
 * Given a string s, return the longest
 * palindromic substring in s.
 *
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
class P005_LongestPalindromicSubstring {

    fun longestPalindrome(s: String): String {
        val session = Session(s)
        return session.longestPalindrome().also {
            println("Hits ${session.hits}")
        }
    }


    private class Session(val s: String) {
        val dp = Array<Array<Boolean?>>(s.length) { Array(s.length) { null } }.also {
            for (i in it.indices) {
                it[i][i] = true
            }
        }
        var hits = 0

        fun longestPalindrome(): String {
            var longest = 0..0
            for (from in s.indices) {
                for (to in (from + 1)..<s.length) {
                    val currentRange = from..to
                    val isPalindrome = checkIsPalindrome(currentRange)
                    if (isPalindrome && longest.length < currentRange.length) {
                        longest = currentRange
                    }
                }
            }

            return s.substring(longest)
        }

        private fun checkIsPalindrome(range: IntRange): Boolean {
            val precalculated = dp[range.first][range.last]
            if (precalculated != null) {
                hits++
                return precalculated
            }

            return run {
                if (range.first == range.last) { // single char
                    return@run true
                }

                if (range.first + 1 == range.last) { // 2 chars
                    return@run s[range.first] == s[range.last]
                }

                return@run s[range.first] == s[range.last] && checkIsPalindrome((range.first + 1)..<range.last)
            }.also {
                dp[range.first][range.last] = it
            }
        }

        val IntRange.length: Int get() = last - first
    }
}
