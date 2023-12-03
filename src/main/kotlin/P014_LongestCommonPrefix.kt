/**
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 */
class P014_LongestCommonPrefix {
    fun longestCommonPrefix(strings: Array<String>): String {
        if (strings.isEmpty()) {
            return ""
        } else if (strings.size == 1) {
            return strings[0]
        }
        val ref = strings[0].toCharArray()
        for (i in ref.indices) {
            val c = ref[i]
            for (j in 1 until strings.size) {
                if (strings[j].length == i) {
                    return strings[j]
                }
                if (strings[j][i] != c) {
                    return strings[j].substring(0, i)
                }
            }
        }
        return strings[0]
    }
}
