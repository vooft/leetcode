/**
 * https://leetcode.com/problems/climbing-stairs/
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
class P070_ClimbingStairs {
    fun climbStairs(n: Int): Int {
        // it is possible to save a bit of memory, but will decrease readability
        val calculatedSteps = IntArray(n + 1)
        return climbStairs(n, calculatedSteps)
    }

    private fun climbStairs(n: Int, calculatedSteps: IntArray): Int {
        return if (calculatedSteps[n] != 0) {
            calculatedSteps[n]
        } else when (n) {
            1 -> 1 // 1
            2 -> 2 // 1 + 1 and 2
            else -> {
                calculatedSteps[n - 1] = climbStairs(n - 1, calculatedSteps)
                calculatedSteps[n - 2] = climbStairs(n - 2, calculatedSteps)
                calculatedSteps[n - 1] + calculatedSteps[n - 2]
            }
        }
    }
}
