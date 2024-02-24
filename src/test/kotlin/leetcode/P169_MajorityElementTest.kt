package leetcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class P169_MajorityElementTest {
    @Test
    fun `sample test 1`() {
        val nums = listOf(3, 2, 3)
        val expected = 3

        val actual = P169_MajorityElement().majorityElement(nums.toIntArray())
        actual shouldBe expected
    }

    @Test
    fun `sample test 2`() {
        val nums = listOf(2, 2, 1, 1, 1, 2, 2)
        val expected = 2

        val actual = P169_MajorityElement().majorityElement(nums.toIntArray())
        actual shouldBe expected
    }
}
