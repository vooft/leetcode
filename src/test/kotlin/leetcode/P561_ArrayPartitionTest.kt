package leetcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class P561_ArrayPartitionTest {
    @Test
    fun `simple test 1`() {
        val nums = intArrayOf(1, 4, 3, 2)
        val expected = 4

        val actual = P561_ArrayPartition().arrayPairSum(nums)

        actual shouldBe expected
    }

    @Test
    fun `simple test 2`() {
        val nums = intArrayOf(6, 2, 6, 5, 1, 2)
        val expected = 9

        val actual = P561_ArrayPartition().arrayPairSum(nums)

        actual shouldBe expected
    }
}
