import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class UniqueBinarySearchTreesTest {
    @ParameterizedTest
    @CsvSource("1,1", "2,2", "3,5", "4,14", "5,42")
    fun testUniqueTrees(n: Int, expected: Int) {
        val solution = UniqueBinarySearchTrees()
        val actual = solution.numTrees(n)
        Assertions.assertEquals(expected, actual)
    }
}
