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
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }

        char[] ref = strs[0].toCharArray();
        for (int i = 0; i < ref.length; i++) {
            char c = ref[i];

            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i) {
                    return strs[j];
                }

                if (strs[j].charAt(i) != c) {
                    return strs[j].substring(0, i);
                }
            }
        }

        return strs[0];
    }

}
