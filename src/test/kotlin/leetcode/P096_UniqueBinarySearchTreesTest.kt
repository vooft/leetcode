package leetcode

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class P096_UniqueBinarySearchTreesTest : FunSpec({
    context("should find unique trees") {
        withData(1 to 1, 2 to 2, 3 to 5, 4 to 14, 5 to 42) { (n, expected) ->
            val solution = P096_UniqueBinarySearchTrees()
            val actual = solution.numTrees(n)
            actual shouldBe expected
        }
    }
})
