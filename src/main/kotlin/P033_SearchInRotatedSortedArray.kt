/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 */
class P033_SearchInRotatedSortedArray {
    fun search(nums: IntArray, target: Int): Int {
        return nums.search(nums.indices, target) ?: -1
    }

    private fun IntArray.search(range: IntRange, target: Int): Int? {
        if (range.isEmpty()) {
            return null
        }

        val pivotIndex = range.first + (range.last - range.first) / 2
        val pivot = get(pivotIndex)
        if (pivot == target) {
            return pivotIndex
        }

        val beforePivotRange = range.first until  pivotIndex
        val afterPivotRange = (pivotIndex + 1)..range.last

        if (isAscending(range)) {
            // sorted part, normal binary search
            return when {
                target < pivot -> search(beforePivotRange, target)
                else -> search(afterPivotRange, target)
            }
        } else {
            return search(beforePivotRange, target) ?: search(afterPivotRange, target)
        }
    }

    private fun IntArray.isAscending(range: IntRange) = get(range.first) < get(range.last)
}
