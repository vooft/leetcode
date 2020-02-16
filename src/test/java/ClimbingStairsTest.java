import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClimbingStairsTest {
    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,3", "4,5", "6,13"})
    void testClimbingStars(int numberOfStairs, int expectedResult) {
        ClimbingStairs solution = new ClimbingStairs();
        int actualResult = solution.climbStairs(numberOfStairs);
        assertEquals(expectedResult, actualResult);
    }
}
