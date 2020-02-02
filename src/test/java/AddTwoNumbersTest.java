import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddTwoNumbersTest {

    private static class TestCase {
        AddTwoNumbers.ListNode number1;
        AddTwoNumbers.ListNode number2;
        long result;

        public TestCase(AddTwoNumbers.ListNode number1, AddTwoNumbers.ListNode number2, long result) {
            this.number1 = number1;
            this.number2 = number2;
            this.result = result;
        }

        @Override
        public String toString() {
            return "TestCase{" +
                    "number1=" + number1 +
                    ", number2=" + number2 +
                    ", result=" + result +
                    '}';
        }
    }

    private static long toLong(AddTwoNumbers.ListNode node) {
        long result = 0;
        long degree = 1;
        while (node != null) {
            result += node.val * degree;
            node = node.next;
            degree *= 10;
        }

        return result;
    }

    private static AddTwoNumbers.ListNode fromInt(int value) {
        AddTwoNumbers.ListNode result = null;
        AddTwoNumbers.ListNode current = null;
        while (value > 0) {
            int v = value % 10;
            value /= 10;

            AddTwoNumbers.ListNode node = new AddTwoNumbers.ListNode(v);
            if (result == null) {
                result = node;
            }

            if (current != null) {
                current.next = node;
            }

            current = node;
        }

        return result;
    }

    private static Collection<TestCase> generateNumbers() {
        return List.of(
                new TestCase(fromInt(123), fromInt(321), 123 + 321),
                new TestCase(fromInt(11), fromInt(12), 11 + 12),
                new TestCase(fromInt(1), fromInt(3), 1 + 3),
                new TestCase(fromInt(Integer.MAX_VALUE), fromInt(Integer.MAX_VALUE), Integer.MAX_VALUE + (long) Integer.MAX_VALUE),
                new TestCase(fromInt(0), fromInt(0), 0),
                new TestCase(fromInt(12345), fromInt(321), 12345 + 321)
        );
    }

    @ParameterizedTest
    @MethodSource("generateNumbers")
    void should_add_numbers(TestCase numbers) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        AddTwoNumbers.ListNode result = addTwoNumbers.addTwoNumbers(numbers.number1, numbers.number2);
        assertEquals(numbers.result, toLong(result));
    }
}
