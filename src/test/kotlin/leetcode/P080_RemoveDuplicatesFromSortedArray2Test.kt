package leetcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class P080_RemoveDuplicatesFromSortedArray2Test {
    @Test
    fun `sample case 1`() {
        val nums = intArrayOf(1, 1, 1, 2, 2, 3)
        val expected = listOf(1, 1, 2, 2, 3)

        val actualK = P080_RemoveDuplicatesFromSortedArray2().removeDuplicates(nums)
        actualK shouldBe expected.size
        nums.take(actualK) shouldBe expected
    }

    @Test
    fun `sample case 2`() {
        val nums = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
        val expected = listOf(0, 0, 1, 1, 2, 3, 3)

        val actualK = P080_RemoveDuplicatesFromSortedArray2().removeDuplicates(nums)
        actualK shouldBe expected.size
        nums.take(actualK) shouldBe expected
    }
}
