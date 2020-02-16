import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumSubarrayTest {

    private final MaximumSubarray maximumSubarray = new MaximumSubarray();

    @Test
    void testSample() {
        int[] given = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int expected = 6;

        int actual = maximumSubarray.maxSubArray(given);

        assertEquals(expected, actual);
    }

    @Test
    void testOnlyPositive() {
        int[] given = new int[]{1, 2};
        int expected = 3;

        int actual = maximumSubarray.maxSubArray(given);

        assertEquals(expected, actual);
    }

    @Test
    void testOnlyNegative() {
        int[] given = new int[]{-1, -2};
        int expected = -1;

        int actual = maximumSubarray.maxSubArray(given);

        assertEquals(expected, actual);
    }
}
