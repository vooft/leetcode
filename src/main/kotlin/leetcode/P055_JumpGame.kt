package leetcode

import kotlin.math.min

/**
 * https://leetcode.com/problems/jump-game
 *
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 *
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 * Constraints:
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 */
class P055_JumpGame {
    fun canJump(nums: IntArray): Boolean {
        val cache = Array<Boolean?>(nums.size) { null }
        return canJumpFrom(nums, 0, cache)
    }

    private fun canJumpFrom(nums: IntArray, position: Int, cache: Array<Boolean?>): Boolean {
        val cached = cache[position]
        if (cached != null) {
            return cached
        }

        return run {
            if (position == nums.size - 1) {
                return@run true
            }

            val distance = nums[position]
            val startPosition = position + 1
            val endPosition = min(position + distance, nums.size - 1)
            for (i in startPosition..endPosition) {
                if (canJumpFrom(nums, i, cache)) {
                    return@run true
                }
            }

            return@run false
        }.also {
            cache[position] = it
        }
    }
}
