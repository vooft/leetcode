package leetcode.extra

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */
class P034_FindFirstAndLastPositionOfElementInSortedArray {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val session = SolutionSession(nums, target)
        return session.findRange()?.let { intArrayOf(it.first, it.last) } ?: intArrayOf(-1, -1)
    }

    class SolutionSession(private val nums: IntArray, private val target: Int) {

        fun findRange(): IntRange? {
            val targetPosition = findPosition(range = nums.indices) { pos ->
                val current = nums[pos]
                when {
                    current > target -> Position.RIGHT_OF_TARGET
                    current < target -> Position.LEFT_OF_TARGET
                    else -> Position.BINGO
                }
            } ?: return null

            val leftEdge = findPosition(0..targetPosition) { pos ->
                val current = nums[pos]

                if (pos == 0) {
                    if (current == target) {
                        return@findPosition Position.BINGO
                    } else {
                        return@findPosition Position.LEFT_OF_TARGET
                    }
                }

                val previous = nums[pos - 1]
                when {
                    previous == target -> Position.RIGHT_OF_TARGET
                    current == target && previous < target -> Position.BINGO
                    current < target -> Position.LEFT_OF_TARGET
                    else -> error("Invalid position for left edge search: $pos, target: $target, current: $current")
                }
            } ?: error("Unable to find the left edge")

            val rightEdge = findPosition(targetPosition..<nums.size) { pos ->
                val current = nums[pos]

                // we are at the edge of the list
                if (pos == nums.size - 1) {
                    if (current == target) {
                        return@findPosition Position.BINGO
                    } else {
                        return@findPosition Position.RIGHT_OF_TARGET
                    }
                }

                val next = nums[pos + 1]
                when {
                    next == target -> Position.LEFT_OF_TARGET
                    current == target && next > target -> Position.BINGO
                    current > target -> Position.RIGHT_OF_TARGET
                    else -> error("Invalid position for right edge search: $pos, target: $target, current: $current")
                }
            } ?: error("Unable to find the right edge")

            return leftEdge..rightEdge
        }

        private fun findPosition(range: IntRange, decider: PositionDecider): Int? {
            if (range.isEmpty()) {
                return null
            }

            val position = range.first + (range.last - range.first) / 2

            return when (decider.decide(position)) {
                Position.LEFT_OF_TARGET -> findPosition((position + 1)..range.last, decider)
                Position.RIGHT_OF_TARGET -> findPosition(range.first..<position, decider)
                Position.BINGO -> position
            }
        }
    }

    fun interface PositionDecider {
        fun decide(position: Int): Position
    }

    enum class Position {
        LEFT_OF_TARGET,
        RIGHT_OF_TARGET,
        BINGO
    }
}
