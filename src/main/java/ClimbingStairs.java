/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        // it is possible to save a bit of memory, but will decrease readability
        int[] calculatedSteps = new int[n + 1];
        return climbStairs(n, calculatedSteps);
    }

    private int climbStairs(int n, int[] calculatedSteps) {
        if (calculatedSteps[n] != 0) {
            return calculatedSteps[n];
        }

        switch (n) {
            case 1: return 1; // 1
            case 2: return 2; // 1 + 1 and 2
            default:
                calculatedSteps[n - 1] = climbStairs(n - 1, calculatedSteps);
                calculatedSteps[n - 2] = climbStairs(n - 2, calculatedSteps);
                return calculatedSteps[n - 1] + calculatedSteps[n - 2];
        }
    }
}
