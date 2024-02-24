package leetcode

import kotlin.math.min

/**
 * https://leetcode.com/problems/container-with-most-water
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that
 * the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 *
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 *
 * Constraints:
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */
class P011_ContainerWithMostWater {
    fun maxArea(heights: IntArray): Int {
        var left = 0
        var right = heights.size - 1

        var maxVolume = 0
        while (left < right) {
            val leftHeight = heights[left]
            val rightHeight = heights[right]

            val minHeight = min(leftHeight, rightHeight)
            val volume = minHeight * (right - left)
            if (maxVolume < volume) {
                maxVolume = volume
            }

            if (leftHeight < rightHeight) {
                left++
            } else {
                right--
            }
        }

        return maxVolume
    }
}
