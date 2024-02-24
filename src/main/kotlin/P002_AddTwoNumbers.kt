/**
 * https://leetcode.com/problems/add-two-numbers/
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
class P002_AddTwoNumbers {
    data class ListNode(val value: Int) {
        var next: ListNode? = null
    }

    fun addTwoNumbers(originalL1: ListNode, originalL2: ListNode): ListNode {
        var l1: ListNode? = originalL1
        var l2: ListNode? = originalL2

        val startNode = ListNode(-1)
        var currentDigit = startNode
        var carryover = false

        while (l1 != null || l2 != null) {

            var val1 = 0
            if (l1 != null) {
                val1 = l1.value
                l1 = l1.next
            }

            var val2 = 0
            if (l2 != null) {
                val2 = l2.value
                l2 = l2.next
            }

            var value = val1 + val2 + if (carryover) 1 else 0
            if (value < 10) {
                carryover = false
            } else {
                value -= 10
                carryover = true
            }

            val oldDigit = currentDigit
            currentDigit = ListNode(value)
            oldDigit.next = currentDigit
        }

        if (carryover) {
            currentDigit.next = ListNode(1)
        }

        return startNode.next!!
    }
}
