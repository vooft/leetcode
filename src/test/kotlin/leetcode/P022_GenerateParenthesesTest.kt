package leetcode

import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import org.junit.jupiter.api.Test

class P022_GenerateParenthesesTest {

    @Test
    fun `simplest test 1`() {
        val expected = listOf("()")
        val actual = P022_GenerateParentheses().generateParenthesis(1)
        println(actual)

        actual shouldContainExactlyInAnyOrder expected
    }

    @Test
    fun `simple test 2`() {
        val expected = listOf("(())", "()()")
        val actual = P022_GenerateParentheses().generateParenthesis(2)
        println(actual)

        actual shouldContainExactlyInAnyOrder expected
    }

    @Test
    fun `simple test 3`() {
        val expected = listOf("((()))", "(()())", "(())()", "()(())", "()()()")
        val actual = P022_GenerateParentheses().generateParenthesis(3)
        println(actual)

        actual shouldContainExactlyInAnyOrder expected
    }
}
