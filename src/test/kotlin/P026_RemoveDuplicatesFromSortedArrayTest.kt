import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.Arrays

internal class P026_RemoveDuplicatesFromSortedArrayTest {
    class TestCase(var nums: IntArray, var length: Int) {
        override fun toString(): String {
            return "{" +
                    "nums=" + nums.contentToString() +
                    ", length=" + length +
                    '}'
        }
    }

    @ParameterizedTest
    @MethodSource("testCases")
    fun should_remove_duplicates(testCase: TestCase) {
        val removeDuplicatesFromSortedArray = P026_RemoveDuplicatesFromSortedArray()
        val newLength = removeDuplicatesFromSortedArray.removeDuplicates(testCase.nums)
        println(Arrays.stream(testCase.nums).limit(newLength.toLong()).toArray().contentToString())
        Assertions.assertEquals(newLength.toLong(), Arrays.stream(testCase.nums).distinct().count())
        Assertions.assertEquals(testCase.length, newLength)
    }

    companion object {
        @JvmStatic
        fun testCases(): Collection<TestCase> {
            return listOf(
                TestCase(intArrayOf(1, 1, 2), 2),
                TestCase(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4), 5),
                TestCase(IntArray(10000) { it }, 10000),
                TestCase(IntArray(10000) { 1 }, 1)
            )
        }
    }
}
