package leetcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class P045_JumpGame2Test {
    @Test
    fun `sample case 1`() {
        val nums = listOf(2, 3, 1, 1, 4)
        val expected = 2

        val actual = P045_JumpGame2().jump(nums.toIntArray())
        actual shouldBe expected
    }

    @Test
    fun `sample case 2`() {
        val nums = listOf(2, 3, 0, 1, 4)
        val expected = 2

        val actual = P045_JumpGame2().jump(nums.toIntArray())
        actual shouldBe expected
    }

    @Test
    fun `can jump out of bounds`() {
        val nums = listOf(2, 1)
        val expected = 1

        val actual = P045_JumpGame2().jump(nums.toIntArray())
        actual shouldBe expected
    }
}
