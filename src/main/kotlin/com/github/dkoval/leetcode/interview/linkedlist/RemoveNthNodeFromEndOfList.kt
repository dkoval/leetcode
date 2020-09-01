package com.github.dkoval.leetcode.interview.linkedlist

import com.github.dkoval.leetcode.ListNode

/**
 * [Remove Nth Node From End of List](https://leetcode.com/explore/featured/card/top-interview-questions-easy/93/linked-list/603/)
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 */
object RemoveNthNodeFromEndOfList {

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        // Add an auxiliary "dummy" node, which points to the list head.
        // The "dummy" node is used to simplify some corner cases such as a list with only one node,
        // or removing the head of the list.
        val dummy = ListNode(42)
        dummy.next = head
        var slow: ListNode? = dummy
        var curr: ListNode? = dummy

        // advance `curr` by n + 1 steps to create n nodes gap between `curr` and `slow` pointers
        repeat(n + 1) {
            curr = curr?.next
        }

        // move `curr` to the end, maintaining the gap
        while (curr != null) {
            curr = curr?.next
            slow = slow?.next
        }
        slow?.next = slow?.next?.next
        return dummy.next
    }
}