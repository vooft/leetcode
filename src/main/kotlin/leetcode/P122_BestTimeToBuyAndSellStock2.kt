package leetcode

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 * Find and return the maximum profit you can achieve.
 *
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 *
 * Example 2:
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Total profit is 4.
 *
 * Example 3:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 *
 * Constraints:
 * 1 <= prices.length <= 3 * 104
 * 0 <= prices[i] <= 104
 */
class P122_BestTimeToBuyAndSellStock2 {
    fun maxProfit(prices: IntArray): Int {
        val session = Session(prices)
        val profit = session.solve()
        println("hits ${session.hits}")
        println("iterations ${session.iterations}")
        println("profit: $profit")
        return profit.amount
    }

    class Session(private val prices: IntArray) {
        var iterations = 0
        var hits = 0
        val purchaseOnCache = mutableMapOf<Int, Profit>()

        fun solve(): Profit {
            var result = Profit(0, listOf())

            for (index in prices.indices) {
                val profit = solveRecursively(index)
                if (result.amount < profit.amount) {
                    result = profit
                }
            }

            return result
        }

        private fun solveRecursively(purchaseOn: Int): Profit {
            val cached = purchaseOnCache[purchaseOn]
            if (cached != null) {
                hits++
                return cached
            }

            iterations++

            val purchasePrice = prices[purchaseOn]

            var maxProfit = Profit(0, listOf())
            for (i in (purchaseOn + 1)..<prices.size) {
                val currentPrice = prices[i]
                if (purchasePrice >= currentPrice) {
                    continue
                }

                val currentProfit = currentPrice - purchasePrice

                var maxFurtherProfit = Profit(0, listOf())
                for (j in i..<prices.size) {
                    val furtherProfit = solveRecursively(j)
                    if (maxFurtherProfit.amount < furtherProfit.amount) {
                        maxFurtherProfit = furtherProfit
                    }
                }

                val totalProfit = currentProfit + maxFurtherProfit.amount
                if (maxProfit.amount < totalProfit) {
                    maxProfit = Profit(amount = totalProfit, deals = listOf(purchaseOn to i) + maxFurtherProfit.deals)
                }
            }

            purchaseOnCache[purchaseOn] = maxProfit
            return maxProfit
        }

        data class Profit(val amount: Int, val deals: List<Pair<Int, Int>>)
    }
}
