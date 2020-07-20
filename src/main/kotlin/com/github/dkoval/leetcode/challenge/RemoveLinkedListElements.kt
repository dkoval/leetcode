package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode

/**
 * [Remove Linked List Elements](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3396/)
 *
 * Remove all elements from a linked list of integers that have value val.
 */
object RemoveLinkedListElements {

    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        if (head == null) return null
        var newHead = head
        var prev: ListNode? = null
        var curr = head
        while (curr != null) {
            val next = curr.next
            if (curr.`val` == `val`) {
                if (curr == newHead) {
                    newHead.next = null
                    newHead = next
                } else {
                    prev?.next = next
                    curr.next = null
                }
            } else {
                prev = curr
            }
            curr = next
        }
        return newHead
    }
}