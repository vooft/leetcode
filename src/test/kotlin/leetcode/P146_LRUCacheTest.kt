package leetcode

import io.kotest.assertions.withClue
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class P146_LRUCacheTest {
    @Test
    fun `sample test 1`() {
        val testData = listOf(
            listOf(2),
            listOf(1, 1),
            listOf(2, 2),
            listOf(1),
            listOf(3, 3),
            listOf(2),
            listOf(4, 4),
            listOf(1),
            listOf(3),
            listOf(4)
        )

        val expected = listOf(null, null, null, 1, null, -1, null, -1, 3, 4)

        runTest(testData, expected)
    }

    @Test
    fun `should override existing value without evicting`() {
        val testData = listOf(
            listOf(2), listOf(2), listOf(2, 6), listOf(1), listOf(1, 5), listOf(1, 2), listOf(1), listOf(2)
        )

        val expected = listOf(null, -1, null, -1, null, null, 2, 6)

        runTest(testData, expected)
    }

    @Test
    fun `wrong answer 1`() {
        val testData = listOf(
            listOf(2), listOf(1, 0), listOf(2, 2), listOf(1), listOf(3, 3), listOf(2), listOf(4, 4), listOf(1), listOf(3), listOf(4)
        )

        val expected = listOf(null, null, null, 0, null, -1, null, -1, 3, 4)

        runTest(testData, expected)
    }

    private fun runTest(testData: List<List<Int>>, expected: List<Int?>) {
        println("testData=$testData, expected=$expected")

        testData.size shouldBe expected.size

        val cache = P146_LRUCache(testData.getSingleValue(0), true)
        for (i in 1..<expected.size) { // element 0 is create cache
            val testDatum = testData[i]
            val expectedValue = expected[i]

            withClue("Checking expected[$i]=$expectedValue and testData[$i]=$testDatum") {
                when (testDatum.size) {
                    1 -> cache.get(testDatum[0]) shouldBe expectedValue
                    2 -> cache.put(testDatum[0], testDatum[1])
                    else -> error("Invalid size of the test datum ${testDatum.size}: $testDatum")
                }
            }
        }
    }

    private fun List<List<Int>>.getSingleValue(index: Int): Int {
        val list = get(index)
        withClue("Array at index $index doesn't have size of 1 $list") {
            list.size shouldBe 1
        }

        return list[0]
    }
}
