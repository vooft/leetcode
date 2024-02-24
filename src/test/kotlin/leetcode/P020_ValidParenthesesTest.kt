package leetcode

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class P020_ValidParenthesesTest : FunSpec({

    context("should accept parentheses") {
        withData("()", "()[]{}", "{[()]}", "{((()[]{}[[()(){{{[]}}}]]))}") {
            val solution = P020_ValidParentheses()
            solution.isValid(it) shouldBe true
        }
    }

    context("should not accept parentheses") {
        withData("())", "(){[}]", "()]}", "(((]]]{{{}}}") {
            val solution = P020_ValidParentheses()
            solution.isValid(it) shouldBe false
        }
    }
})
