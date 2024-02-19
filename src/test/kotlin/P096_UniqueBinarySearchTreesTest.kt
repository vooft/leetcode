import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class P096_UniqueBinarySearchTreesTest {
    @ParameterizedTest
    @CsvSource("1,1", "2,2", "3,5", "4,14", "5,42")
    fun testUniqueTrees(n: Int, expected: Int) {
        val solution = P096_UniqueBinarySearchTrees()
        val actual = solution.numTrees(n)
        assertEquals(expected, actual)
    }
}
