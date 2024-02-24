package leetcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class P122_BestTimeToBuyAndSellStock2Test {
    @Test
    fun `simple case 1`() {
        val prices = intArrayOf(7, 1, 5, 3, 6, 4)
        val expected = 7

        val actual = P122_BestTimeToBuyAndSellStock2().maxProfit(prices)

        actual shouldBe expected
    }

    @Test
    fun `simple case 2`() {
        val prices = intArrayOf(1, 2, 3, 4, 5)
        val expected = 4

        val actual = P122_BestTimeToBuyAndSellStock2().maxProfit(prices)

        actual shouldBe expected
    }

    @Test
    fun `simple case 3`() {
        val prices = intArrayOf(7, 6, 4, 3, 1)
        val expected = 0

        val actual = P122_BestTimeToBuyAndSellStock2().maxProfit(prices)

        actual shouldBe expected
    }
}
