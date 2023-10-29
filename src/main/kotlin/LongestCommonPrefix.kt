/**
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
class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.size == 0) {
            return ""
        } else if (strs.size == 1) {
            return strs[0]
        }
        val ref = strs[0].toCharArray()
        for (i in ref.indices) {
            val c = ref[i]
            for (j in 1 until strs.size) {
                if (strs[j].length == i) {
                    return strs[j]
                }
                if (strs[j][i] != c) {
                    return strs[j].substring(0, i)
                }
            }
        }
        return strs[0]
    }
}
