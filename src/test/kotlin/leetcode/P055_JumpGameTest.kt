package leetcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class P055_JumpGameTest {
    @Test
    fun `sample test 1`() {
        val nums = listOf(2, 3, 1, 1, 4)
        val expected = true

        val actual = P055_JumpGame().canJump(nums.toIntArray())

        actual shouldBe expected
    }

    @Test
    fun `sample test 2`() {
        val nums = listOf(3, 2, 1, 0, 4)
        val expected = false

        val actual = P055_JumpGame().canJump(nums.toIntArray())

        actual shouldBe expected
    }
}
