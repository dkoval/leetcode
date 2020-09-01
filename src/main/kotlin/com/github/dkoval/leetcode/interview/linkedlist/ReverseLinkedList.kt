package com.github.dkoval.leetcode.interview.linkedlist

import com.github.dkoval.leetcode.ListNode

/**
 * [Reverse Linked List](https://leetcode.com/explore/featured/card/top-interview-questions-easy/93/linked-list/560/)
 *
 * Reverse a singly linked list.
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
interface ReverseLinkedList {

    fun reverseList(head: ListNode?): ListNode?
}

// Time complexity: O(N), space complexity: O(1)
object ReverseLinkedListIter : ReverseLinkedList {

    override fun reverseList(head: ListNode?): ListNode? {
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
}

// Time complexity: O(N), space complexity: O(N) - the recursion could go up to N levels deep.
object ReverseLinkedListRecursive : ReverseLinkedList {

    override fun reverseList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        // n[1] -> ... -> n[k] -> n[k + 1] <- ... <- n[m]
        // the list from n[k + 1] to n[m] is already reversed
        // we want n[k + 1] to point to n[k], therefore n[k].next.next = n[k]
        val reversed = reverseList(head.next)
        head.next?.next = head
        head.next = null // to prevent cycle
        return reversed
    }
}