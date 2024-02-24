
import P002_AddTwoNumbers.ListNode
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class P002_AddTwoNumbersTest : FunSpec({
    context("should add numbers") {
        withData(
            TestCase(123.toListNode(), 321.toListNode(), (123 + 321).toLong()),
            TestCase(11.toListNode(), 12.toListNode(), (11 + 12).toLong()),
            TestCase(1.toListNode(), 3.toListNode(), (1 + 3).toLong()),
            TestCase(Int.MAX_VALUE.toListNode(), Int.MAX_VALUE.toListNode(), Int.MAX_VALUE + Int.MAX_VALUE.toLong()),
            TestCase(0.toListNode(), 0.toListNode(), 0),
            TestCase(12345.toListNode(), 321.toListNode(), (12345 + 321).toLong())
        ) { numbers ->
            val addTwoNumbers = P002_AddTwoNumbers()
            val result = addTwoNumbers.addTwoNumbers(numbers.number1, numbers.number2)
            numbers.result shouldBe result.toLong()
        }
    }
}) {
    private class TestCase(val number1: ListNode, val number2: ListNode, val result: Long) {
        override fun toString(): String {
            return "TestCase{" +
                    "number1=" + number1 +
                    ", number2=" + number2 +
                    ", result=" + result +
                    '}'
        }
    }

    companion object {
        private fun ListNode.toLong(): Long {
            var node: ListNode? = this
            var result: Long = 0
            var degree: Long = 1
            while (node != null) {
                result += node.value * degree
                node = node.next
                degree *= 10
            }
            return result
        }

        private fun Int.toListNode(): ListNode {
            require(this >= 0) { "Can't convert negative value $this to ListNode" }

            var value = this
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
            return result ?: ListNode(0)
        }

    }
}

