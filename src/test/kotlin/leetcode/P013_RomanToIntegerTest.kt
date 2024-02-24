package leetcode

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import leetcode.extra.P013_RomanToInteger

class P013_RomanToIntegerTest : FunSpec({
    context("should parse roman number") {
        withData(
            "III" to 3,
            "LVIII" to 58,
            "MCMXCIV" to 1994,
            "MDCCLXXVI" to 1776,
            "I" to 1,
            "II" to 2,
            "MDCXCV" to 1695
        ) { (romanNumber, number) ->
            val romanToInteger = P013_RomanToInteger()
            romanToInteger.romanToInt(romanNumber) shouldBe number
        }
    }
})
