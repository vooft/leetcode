import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class UniqueBinarySearchTreesTest {
    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,5", "4,14", "5,42"})
    void testUniqueTrees(int n, int expected) {
        UniqueBinarySearchTrees solution = new UniqueBinarySearchTrees();
        int actual = solution.numTrees(n);
        assertEquals(expected, actual);
    }
}
