package leetcode

import leetcode.extra.P033_SearchInRotatedSortedArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class P033_SearchInRotatedSortedArrayTest {
    @Test
    fun `should find the rotation point`() {
        val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)

        val actual = P033_SearchInRotatedSortedArray().search(nums, 0)

        assertEquals(4, actual)
    }

    @Test
    fun `should find value before rotation`() {
        val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)

        val actual = P033_SearchInRotatedSortedArray().search(nums, 5)

        assertEquals(1, actual)
    }

    @Test
    fun `should find value after rotation`() {
        val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)

        val actual = P033_SearchInRotatedSortedArray().search(nums, 1)

        assertEquals(5, actual)
    }
}
