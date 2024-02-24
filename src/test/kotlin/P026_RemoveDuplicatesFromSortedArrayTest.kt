import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.IsStableType
import io.kotest.datatest.withData
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class P026_RemoveDuplicatesFromSortedArrayTest : FunSpec({

    context("should remove duplicates") {
        withData(
            TestCase(listOf(1, 1, 2), 2),
            TestCase(listOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4), 5),
            TestCase(List(10000) { it }, 10000),
            TestCase(List(10000) { 1 }, 1)
        ) { testCase ->
            val removeDuplicatesFromSortedArray = P026_RemoveDuplicatesFromSortedArray()
            val newLength = removeDuplicatesFromSortedArray.removeDuplicates(testCase.nums.toIntArray())

            println(testCase.nums.take(newLength))

            testCase.nums.distinct() shouldHaveSize newLength
            testCase.length shouldBe newLength
        }
    }
}) {
    @IsStableType
    private data class TestCase(val nums: List<Int>, val length: Int)
}
