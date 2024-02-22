import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class P997_FindTheTownJudgeTest {
    @Test
    fun `simple test 1`() {
        val actual = P997_FindTheTownJudge().findJudge(2, arrayOf(intArrayOf(1, 2)))
        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun `simple test 2`() {
        val actual = P997_FindTheTownJudge().findJudge(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3)))
        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun `simple test 3`() {
        val actual = P997_FindTheTownJudge().findJudge(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3), intArrayOf(3, 1)))
        assertThat(actual).isEqualTo(-1)
    }
}
