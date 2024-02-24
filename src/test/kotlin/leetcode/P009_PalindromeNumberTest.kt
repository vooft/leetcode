package leetcode

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class P009_PalindromeNumberTest : FunSpec({
    context("should accept palindrome") {
        withData(12321, 123321, 121, 333, 22, 1, 999999999) {

        }
    }

    context("should not accept palindrome") {
        withData(-1, -99999, 123, 321, 123456789, Int.MAX_VALUE, Int.MIN_VALUE) {
            val palindromeNumber = P009_PalindromeNumber()
            palindromeNumber.isPalindrome(it) shouldBe false
        }
    }
})
