package leetcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class P621_TaskSchedulerTest {
    @Test
    fun `simple test 1`() {
        val tasks = "AAABBB"
        val n = 2

        val expected = 8

        val actual = P621_TaskScheduler().leastInterval(tasks.toCharArray(), n)

        actual shouldBe expected
    }

    @Test
    fun `simple test 2`() {
        val tasks = "ACABDB"
        val n = 1

        val expected = 6

        val actual = P621_TaskScheduler().leastInterval(tasks.toCharArray(), n)

        actual shouldBe expected
    }

    @Test
    fun `simple test 3`() {
        val tasks = "AAABBB"
        val n = 3

        val expected = 10

        val actual = P621_TaskScheduler().leastInterval(tasks.toCharArray(), n)

        actual shouldBe expected
    }

    @Test
    fun `wrong answer 1`() {
        val tasks = "AAAAAABCDEFG"
        val n = 1

        val expected = 12

        val actual = P621_TaskScheduler().leastInterval(tasks.toCharArray(), n)

        actual shouldBe expected
    }
}
