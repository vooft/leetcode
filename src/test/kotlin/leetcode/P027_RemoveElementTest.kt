package leetcode

import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class P027_RemoveElementTest {
    @Test
    fun `simple case 1`() {
        val nums = intArrayOf(3, 2, 2, 3)
        val value = 3

        val expected = listOf(2, 2)

        val actualK = P027_RemoveElement().removeElement(nums, value)

        actualK shouldBe expected.size
        nums.take(actualK) shouldContainExactlyInAnyOrder expected
    }

    @Test
    fun `simple case 2`() {
        val nums = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
        val value = 2

        val expected = listOf(0, 1, 3, 0, 4)

        val actualK = P027_RemoveElement().removeElement(nums, value)

        actualK shouldBe expected.size
        nums.take(actualK) shouldContainExactlyInAnyOrder expected
    }

}
