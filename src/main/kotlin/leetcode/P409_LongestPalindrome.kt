package leetcode

/**
 * https://leetcode.com/problems/longest-palindrome
 *
 * Given a string s which consists of lowercase or uppercase letters,
 * return the length of the longest palindrome that can be built with those letters.
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 *
 * Example 1:
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 * Example 2:
 * Input: s = "a"
 * Output: 1
 * Explanation: The longest palindrome that can be built is "a", whose length is 1.
 *
 * Constraints:
 * 1 <= s.length <= 2000
 * s consists of lowercase and/or uppercase English letters only.
 */
class P409_LongestPalindrome {
    fun longestPalindrome(s: String): Int {
        val sortedChars = s.toCharArray().apply { sort() }

        var result = 0

        // flag to indicate if there is a single floating char
        // (for case if every other has a pair)
        var singleCharExists = sortedChars.size % 2 == 1

        var i = 0
        while (i < sortedChars.size - 1) {
            if (sortedChars[i] == sortedChars[i + 1]) {
                result += 2
                i += 2
            } else {
                singleCharExists = true
                i++
            }
        }

        return when (singleCharExists) {
            true -> result + 1
            false -> result
        }
    }
}
