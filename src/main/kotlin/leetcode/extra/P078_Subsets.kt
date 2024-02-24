package leetcode.extra

/**
 * https://leetcode.com/problems/subsets/
 *
 * Given an integer array nums of unique elements, return all possible
 * subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 */
class P078_Subsets {
    fun subsets(nums: IntArray): List<List<Int>> {
        return generateSublists(nums.toList(), emptyList())
    }

    private fun generateSublists(list: List<Int>, acc: List<Int>): List<List<Int>> {
        if (list.isEmpty()) {
            return when {
                acc.isNotEmpty() -> listOf(acc)
                else -> listOf()
            }
        }

        val head = list.first()
        val tail = list.drop(1)

        return generateSublists(tail, acc.toList()) +
                generateSublists(tail, (acc + head).toList())
    }
}
