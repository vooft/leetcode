package leetcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class P088_MergeSortedArrayTest {
    @Test
    fun `simple case 1`() {
        val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
        val m = 3
        val nums2 = intArrayOf(2, 5, 6)
        val n = 3

        val expected = intArrayOf(1, 2, 2, 3, 5, 6)

        P088_MergeSortedArray().merge(nums1 = nums1, m = m, nums2 = nums2, n = n)

        nums1 shouldBe expected
    }

    @Test
    fun `simple case 2`() {
        val nums1 = intArrayOf(1)
        val m = 1
        val nums2 = intArrayOf()
        val n = 0

        val expected = intArrayOf(1)

        P088_MergeSortedArray().merge(nums1 = nums1, m = m, nums2 = nums2, n = n)

        nums1 shouldBe expected
    }

    @Test
    fun `simple case 3`() {
        val nums1 = intArrayOf(0)
        val m = 0
        val nums2 = intArrayOf(1)
        val n = 1

        val expected = intArrayOf(1)

        P088_MergeSortedArray().merge(nums1 = nums1, m = m, nums2 = nums2, n = n)

        nums1 shouldBe expected
    }
}
