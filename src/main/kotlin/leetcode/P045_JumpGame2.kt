package leetcode

import kotlin.math.min

/**
 * https://leetcode.com/problems/jump-game-ii
 *
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 * Each element nums[i] represents the maximum length of a forward jump from index i.
 * In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 *
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 * Constraints:
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * It's guaranteed that you can reach nums[n - 1].
 */
class P045_JumpGame2 {
    fun jump(nums: IntArray): Int {
        val cache = Array<Int?>(nums.size) { null }
        return jumpsFrom(nums, 0, cache)!!
    }

    private fun jumpsFrom(nums: IntArray, pos: Int, cache: Array<Int?>): Int? {
        val cached = cache[pos]
        if (cached != null) {
            return cached
        }

        return run {
            if (pos == nums.size - 1) {
                return@run 0
            }

            var min: Int? = null

            val from = pos + 1
            val to = min(pos + nums[pos], nums.size - 1)
            for (i in from..to) {
                val jumps = jumpsFrom(nums, i, cache) ?: continue

                if (min == null || min > jumps) {
                    min = jumps
                }
            }

            return@run min?.let { it + 1 }
        }.also { cache[pos] = it }
    }
}
