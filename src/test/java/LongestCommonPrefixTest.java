import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {
    @Test
    void should_find_longest_prefix() {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String prefix = solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        assertEquals("fl", prefix);
    }

    @Test
    void should_find_longest_prefix2() {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String prefix = solution.longestCommonPrefix(new String[]{"flower", "flow", "flowerist"});
        assertEquals("flow", prefix);
    }

    @Test
    void should_return_empty_for_no_prefix() {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String prefix = solution.longestCommonPrefix(new String[]{"dog","racecar","car"});
        assertEquals("", prefix);
    }

    @Test
    void should_return_empty_for_not_all_prefix() {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String prefix = solution.longestCommonPrefix(new String[]{"dog","racecar","dar"});
        assertEquals("", prefix);
    }

    @Test
    void should_return_for_same_values() {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String prefix = solution.longestCommonPrefix(new String[]{"dog","dog"});
        assertEquals("dog", prefix);
    }

    @Test
    void should_return_single_value() {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String prefix = solution.longestCommonPrefix(new String[]{"dog"});
        assertEquals("dog", prefix);
    }
}
