import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class LongestCommonPrefixTest {
    @Test
    fun should_find_longest_prefix() {
        val solution = LongestCommonPrefix()
        val prefix = solution.longestCommonPrefix(arrayOf("flower", "flow", "flight"))
        Assertions.assertEquals("fl", prefix)
    }

    @Test
    fun should_find_longest_prefix2() {
        val solution = LongestCommonPrefix()
        val prefix = solution.longestCommonPrefix(arrayOf("flower", "flow", "flowerist"))
        Assertions.assertEquals("flow", prefix)
    }

    @Test
    fun should_return_empty_for_no_prefix() {
        val solution = LongestCommonPrefix()
        val prefix = solution.longestCommonPrefix(arrayOf("dog", "racecar", "car"))
        Assertions.assertEquals("", prefix)
    }

    @Test
    fun should_return_empty_for_not_all_prefix() {
        val solution = LongestCommonPrefix()
        val prefix = solution.longestCommonPrefix(arrayOf("dog", "racecar", "dar"))
        Assertions.assertEquals("", prefix)
    }

    @Test
    fun should_return_for_same_values() {
        val solution = LongestCommonPrefix()
        val prefix = solution.longestCommonPrefix(arrayOf("dog", "dog"))
        Assertions.assertEquals("dog", prefix)
    }

    @Test
    fun should_return_single_value() {
        val solution = LongestCommonPrefix()
        val prefix = solution.longestCommonPrefix(arrayOf("dog"))
        Assertions.assertEquals("dog", prefix)
    }
}
