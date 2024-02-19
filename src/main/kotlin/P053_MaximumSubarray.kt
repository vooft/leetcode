/**
 * https://leetcode.com/problems/maximum-subarray/
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
class P053_MaximumSubarray {
    fun maxSubArray(nums: IntArray): Int {
        // Kadane's algorithm
        var currentSum = nums[0]
        var maxSum = currentSum
        for (i in 1 until nums.size) {
            // if previous max subarray + current element is greater than just current element
            // then we add it to the "subarray"
            if (currentSum + nums[i] > nums[i]) {
                currentSum += nums[i]
            } else {
                // if not, then we just abandon previous subarray and start a new one
                currentSum = nums[i]
            }

            // however we track max sum separately from the current subarray
            if (currentSum > maxSum) {
                maxSum = currentSum
            }
        }
        return maxSum
    }
}
