import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class P496_NextGreaterElement1Test {
    @Test
    fun `simple test 1`() {
        val nums1 = intArrayOf(4, 1, 2)
        val nums2 = intArrayOf(1, 3, 4, 2)

        val expected = intArrayOf(-1, 3, -1)

        val actual = P496_NextGreaterElement1().nextGreaterElement(nums1, nums2)

        assertThat(actual).containsExactly(*expected)
    }

    @Test
    fun `simple test 2`() {
        val nums1 = intArrayOf(2, 4)
        val nums2 = intArrayOf(1, 2, 3, 4)

        val expected = intArrayOf(3, -1)

        val actual = P496_NextGreaterElement1().nextGreaterElement(nums1, nums2)

        assertThat(actual).containsExactly(*expected)
    }

    @Test
    fun `simple test 3`() {
        val nums1 = intArrayOf(3, 1, 5, 7, 9, 2, 6)
        val nums2 = intArrayOf(1, 2, 3, 5, 6, 7, 9, 11)

        val expected = intArrayOf(5, 2, 6, 9, 11, 3, 7)

        val actual = P496_NextGreaterElement1().nextGreaterElement(nums1, nums2)

        assertThat(actual).containsExactly(*expected)
    }
}
