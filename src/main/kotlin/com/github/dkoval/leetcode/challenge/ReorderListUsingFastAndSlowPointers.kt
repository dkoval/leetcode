package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.problems.ReorderList

/**
 * [Reorder List](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3430/)
 *
 * Given a singly linked list L: ```L0→L1→…→Ln-1→Ln```,
 * reorder it to: ```L0→Ln→L1→Ln-1→L2→Ln-2→…```
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
object ReorderListUsingFastAndSlowPointers : ReorderList {

    override fun reorderList(head: ListNode?) {
        if (head?.next == null) return
        val (head1, head2) = splitIntoHalves(head)
        val head2Reversed = reverse(head2)
        merge(head1, head2Reversed)
    }

    private fun splitIntoHalves(head: ListNode?): Pair<ListNode?, ListNode?> {
        // using slow & fast iterators here to split the list into 2 halves
        var tail1: ListNode? = null // to point to the last node of the 1st half
        var head2: ListNode? = head // slow iterator; to point to the first node of the 2nd half
        var tail2: ListNode? = head // fast iterator; to point to the last node of the 2nd half
        while (tail2?.next != null) {
            tail1 = head2
            head2 = head2?.next
            tail2 = tail2.next?.next
        }
        tail1?.next = null
        return head to head2
    }

    private fun reverse(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr = head
        while (curr != null) {
            val next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }
        return prev
    }

    private fun merge(head1: ListNode?, head2: ListNode?) {
        var curr1 = head1
        var curr2 = head2
        while (curr1 != null) {
            val next1 = curr1.next
            val next2 = curr2?.next
            curr1.next = curr2
            if (next1 == null) {
                break
            }
            curr2?.next = next1
            curr1 = next1
            curr2 = next2
        }
    }
}