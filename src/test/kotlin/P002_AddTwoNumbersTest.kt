
import P002_AddTwoNumbers.ListNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class P002_AddTwoNumbersTest {
    @ParameterizedTest
    @MethodSource("generateNumbers")
    fun should_add_numbers(numbers: TestCase) {
        val addTwoNumbers = P002_AddTwoNumbers()
        val result = addTwoNumbers.addTwoNumbers(numbers.number1, numbers.number2)
        Assertions.assertEquals(numbers.result, toLong(result))
    }

    companion object {
        private fun toLong(originalNode: ListNode?): Long {
            var node = originalNode
            var result: Long = 0
            var degree: Long = 1
            while (node != null) {
                result += node.value * degree
                node = node.next
                degree *= 10
            }
            return result
        }

        private fun fromInt(originalValue: Int): ListNode? {
            var value = originalValue
            var result: ListNode? = null
            var current: ListNode? = null
            while (value > 0) {
                val v = value % 10
                value /= 10
                val node = ListNode(v)
                if (result == null) {
                    result = node
                }
                if (current != null) {
                    current.next = node
                }
                current = node
            }
            return result
        }

        @JvmStatic
        fun generateNumbers(): Collection<TestCase> {
            return listOf(
                TestCase(fromInt(123), fromInt(321), (123 + 321).toLong()),
                TestCase(fromInt(11), fromInt(12), (11 + 12).toLong()),
                TestCase(fromInt(1), fromInt(3), (1 + 3).toLong()),
                TestCase(fromInt(Int.MAX_VALUE), fromInt(Int.MAX_VALUE), Int.MAX_VALUE + Int.MAX_VALUE.toLong()),
                TestCase(fromInt(0), fromInt(0), 0),
                TestCase(fromInt(12345), fromInt(321), (12345 + 321).toLong())
            )
        }
    }
}

internal class TestCase(var number1: ListNode?, var number2: ListNode?, var result: Long) {
    override fun toString(): String {
        return "TestCase{" +
                "number1=" + number1 +
                ", number2=" + number2 +
                ", result=" + result +
                '}'
    }
}
