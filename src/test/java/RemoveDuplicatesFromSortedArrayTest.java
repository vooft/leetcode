import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicatesFromSortedArrayTest {

    private static class TestCase {
        int[] nums;
        int length;

        public TestCase(int[] nums, int length) {
            this.nums = nums;
            this.length = length;
        }

        @Override
        public String toString() {
            return "{" +
                    "nums=" + Arrays.toString(nums) +
                    ", length=" + length +
                    '}';
        }
    }

    private static Collection<TestCase> testCases() {
        return List.of(
                new TestCase(new int[]{1,1,2}, 2),
                new TestCase(new int[]{0,0,1,1,1,2,2,3,3,4}, 5),
                new TestCase(IntStream.range(0, 10000).toArray(), 10000),
                new TestCase(IntStream.range(0, 10000).map(__ -> 1).toArray(), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void should_remove_duplicates(TestCase testCase) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int newLength = removeDuplicatesFromSortedArray.removeDuplicates(testCase.nums);

        System.out.println(Arrays.toString(Arrays.stream(testCase.nums).limit(newLength).toArray()));
        assertEquals(newLength, Arrays.stream(testCase.nums).distinct().count());
        assertEquals(testCase.length, newLength);
    }
}
