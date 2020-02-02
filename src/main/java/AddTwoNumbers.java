/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "{" +
                    "val=" + val +
                    '}';
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode startNode = new ListNode(-1);
        ListNode currentDigit = startNode;

        boolean carryover = false;
        while (l1 != null || l2 != null) {
            int val1 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }


            int val2 = 0;
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }

            int value = val1 + val2 + (carryover ? 1 : 0);

            if (value < 10) {
                carryover = false;
            } else {
                value -= 10;
                carryover = true;
            }

            ListNode oldDigit = currentDigit;
            currentDigit = new ListNode(value);
            oldDigit.next = currentDigit;
        }

        if (carryover) {
            currentDigit.next = new ListNode(1);
        }

        return startNode.next;
    }
}
