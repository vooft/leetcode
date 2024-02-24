package leetcode.extra

/**
 * https://leetcode.com/problems/palindrome-number/
 *
 * Determine whether an integer is a palindrome.
 * An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 * Input: 121
 * Output: true
 *
 * Example 2:
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
 * Therefore it is not a palindrome.
 *
 * Example 3:
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * Follow up:
 * Could you solve it without converting the integer to a string?
 */
class P009_PalindromeNumber {
    fun isPalindrome(originalValue: Int): Boolean {
        if (originalValue < 0) {
            // all negative numbers are not palindromes
            return false
        } else if (originalValue < 10) {
            // all single-digit numbers are palindromes
            return true
        }

        // accumulate single digits in a stack
        // find the middle, then start popping values from the stack
        val stack = ArrayDeque<Int>()

        // will hold the remaining front digits
        var remainingDigits = originalValue

        // accumulator will hold 9999... for every processed digit
        // once the remaining digits are less than the accumulator, then we found the middle
        var accumulator = 0 // will accumulate 99999... to find the middle

        while (remainingDigits > 0) {
            val currentDigit = remainingDigits % 10

            val pastMiddle = remainingDigits <= accumulator

            remainingDigits /= 10

            if (!pastMiddle) {
                // for an even number of digits, we need to move point by 2
                // normally by dividing remainingDigits by 2 AND adding one more 9 to accumulator

                /*
                    +-----------+-----+-------+--------+------+--------+
                    | iteration | acc | even  | <= acc | odd  | <= acc |
                    +-----------+-----+-------+--------+------+--------+
                    | 1 before  | 0   | 12 34 | false  | 12 3 | false  |
                    | 1 after   | 0   | 12 3  | false  | 12   | false  |
                    | 2 before  | 9   | 12 3  | false  | 12   | false  |
                    | 2 after   | 9   | 12    | false  | 1    | true   |
                    | 3 before  | 99  | 12    | true   |      |        |
                    +-----------+-----+-------+--------+------+--------+
                 */

                if (remainingDigits <= accumulator) {
                    // there is an odd number of digits
                    // just need to skip adding to the stack
                } else {
                    stack.addLast(currentDigit)
                }
            } else {
                if (currentDigit != stack.removeLast()) {
                    return false
                }
            }

            accumulator = accumulator * 10 + 9
        }
        return true
    }
}
