package leetcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class P053_MaximumSubarrayTest {
    private val maximumSubarray = P053_MaximumSubarray()

    @Test
    fun testSample() {
        val given = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
        val expected = 6
        val actual = maximumSubarray.maxSubArray(given)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun testOnlyPositive() {
        val given = intArrayOf(1, 2)
        val expected = 3
        val actual = maximumSubarray.maxSubArray(given)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun testOnlyNegative() {
        val given = intArrayOf(-1, -2)
        val expected = -1
        val actual = maximumSubarray.maxSubArray(given)
        Assertions.assertEquals(expected, actual)
    }
}
