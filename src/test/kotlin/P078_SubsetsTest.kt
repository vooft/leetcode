import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import org.junit.jupiter.api.Test

class P078_SubsetsTest {
    @Test
    fun `should generate sublists`() {
        val source = intArrayOf(1, 2, 3)

        val actual = P078_Subsets().subsets(source)
        val expected = listOf(
            listOf(1), listOf(2), listOf(3),
            listOf(1, 2), listOf(1, 3),
            listOf(2, 3),
            listOf(1, 2, 3)
        )

        actual shouldContainExactlyInAnyOrder expected
    }
}
