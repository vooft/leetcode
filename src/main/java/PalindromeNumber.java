import java.util.Deque;
import java.util.LinkedList;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 *
 * Could you solve it without converting the integer to a string?
 */
public class PalindromeNumber {
    public boolean isPalindrome(int value) {
        if (value < 0) {
            return false;
        } else if (value < 10) {
            return true;
        }

        Deque<Integer> stack = new LinkedList<>();

        int accumulator = 0; // will accumulate 99999... to find the middle
        while (value > 0) {
            int currentDigit = value % 10;

            boolean pastMiddle = value <= accumulator;

            value /= 10;
            if (!pastMiddle) {
                if (value <= accumulator) {
                    // there is an odd number of digits
                    // just need to skip adding to the stack
                } else {
                    stack.push(currentDigit);
                }
            } else {
                if (currentDigit != stack.pop()) {
                    return false;
                }
            }

            accumulator = accumulator * 10 + 9;
        }

        return true;
    }
}
