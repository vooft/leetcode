package leetcode

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class P070_ClimbingStairsTest : FunSpec({
    context("climbing stairs") {
        withData(1 to 1, 2 to 2, 3 to 3, 4 to 5, 6 to 13) { (numberOfStairs, expectedResult) ->
            val solution = P070_ClimbingStairs()
            val actualResult = solution.climbStairs(numberOfStairs)
            actualResult shouldBe expectedResult
        }
    }
})
