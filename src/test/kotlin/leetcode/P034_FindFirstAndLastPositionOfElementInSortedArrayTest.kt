package leetcode

import leetcode.extra.P034_FindFirstAndLastPositionOfElementInSortedArray
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class P034_FindFirstAndLastPositionOfElementInSortedArrayTest {

    private val solution = P034_FindFirstAndLastPositionOfElementInSortedArray()

    @Test
    fun `should find position`() {
        val actual = solution.searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8)

        assertArrayEquals(intArrayOf(3, 4), actual)
    }

    @Test
    fun `should find position of a single value`() {
        val actual = solution.searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 10)

        assertArrayEquals(intArrayOf(5, 5), actual)
    }

    @Test
    fun `should not find position`() {
        val actual = solution.searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6)

        assertArrayEquals(intArrayOf(-1, -1), actual)
    }

    @Test
    fun `should not find position in an empty array`() {
        val actual = solution.searchRange(intArrayOf(), 1)

        assertArrayEquals(intArrayOf(-1, -1), actual)
    }

    @Test
    fun `should find position in a single-element array`() {
        val actual = solution.searchRange(intArrayOf(1), 1)

        assertArrayEquals(intArrayOf(0, 0), actual)
    }

    @Test
    fun `should find position in an array of 2 elements`() {
        val actual = solution.searchRange(intArrayOf(1, 2), 2)

        assertArrayEquals(intArrayOf(1, 1), actual)
    }
}
