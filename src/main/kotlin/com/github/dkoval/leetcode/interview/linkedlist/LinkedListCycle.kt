package com.github.dkoval.leetcode.interview.linkedlist

import com.github.dkoval.leetcode.ListNode

/**
 * [Linked List Cycle](https://leetcode.com/explore/featured/card/top-interview-questions-easy/93/linked-list/773/)
 *
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
 * in the linked list where the tail connects to. If pos == -1, then there is no cycle in the linked list.
 *
 * Follow up:
 * Can you solve it using O(1) (i.e. constant) memory?
 */
object LinkedListCycle {

    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head
        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
            if (slow == fast) return true
        }
        return false
    }
}