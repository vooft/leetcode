import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class P011_ContainerWithMostWaterTest {
    @Test
    fun `simple test 1`() {
        val height = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
        val expected = 49

        val actual = P011_ContainerWithMostWater().maxArea(height)

        actual shouldBe expected
    }

    @Test
    fun `simple test 2`() {
        val height = intArrayOf(1, 1)
        val expected = 1

        val actual = P011_ContainerWithMostWater().maxArea(height)

        actual shouldBe expected
    }
}
