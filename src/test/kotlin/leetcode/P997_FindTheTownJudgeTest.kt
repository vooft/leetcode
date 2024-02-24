package leetcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class P997_FindTheTownJudgeTest {
    @Test
    fun `simple test 1`() {
        val actual = P997_FindTheTownJudge().findJudge(2, arrayOf(intArrayOf(1, 2)))
        actual shouldBe 2
    }

    @Test
    fun `simple test 2`() {
        val actual = P997_FindTheTownJudge().findJudge(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3)))
        actual shouldBe 3
    }

    @Test
    fun `simple test 3`() {
        val actual = P997_FindTheTownJudge().findJudge(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3), intArrayOf(3, 1)))
        actual shouldBe -1
    }
}
