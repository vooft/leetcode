import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class ClimbingStairsTest {
    @ParameterizedTest
    @CsvSource("1,1", "2,2", "3,3", "4,5", "6,13")
    fun testClimbingStars(numberOfStairs: Int, expectedResult: Int) {
        val solution = ClimbingStairs()
        val actualResult = solution.climbStairs(numberOfStairs)
        Assertions.assertEquals(expectedResult, actualResult)
    }
}
