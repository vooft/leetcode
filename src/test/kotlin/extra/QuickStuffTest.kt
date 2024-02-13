package extra

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class QuickStuffTest {
    @Test
    fun `should sort`() {
        val unsorted = listOf(3, 1, 4, 2, 9, 0, -1)

        val actual = QuickStuff<Int>().sort(unsorted)
        println("unsorted $unsorted")
        println("actual $actual")

        assertEquals(listOf(1, 2, 3, 4), actual)
    }

    @Test
    fun `should select kth`() {
        val unsorted = listOf(3, 1, 4, 2, 9, 0, -1)

        val actual = QuickStuff<Int>().kth(unsorted, 2)

        assertEquals(1, actual)
    }
}
