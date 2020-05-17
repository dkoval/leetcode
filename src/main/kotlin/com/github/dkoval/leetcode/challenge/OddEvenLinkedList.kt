package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode

/**
 * [Odd Even Linked List](https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3331/)
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 */
object OddEvenLinkedList {

    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }

        val odd = ListNodeExt()
        val even = ListNodeExt()

        var current = head
        var count = 1
        while (current != null) {
            val target = if (count % 2 == 1) odd else even
            target.append(current)
            current = current.next
            count++
        }

        odd.last?.next = even.head
        even.last?.next = null
        return odd.head
    }

    private class ListNodeExt(
        var head: ListNode? = null,
        var last: ListNode? = head
    ) {

        fun append(node: ListNode): ListNodeExt {
            if (head == null) {
                head = node
                last = head
            } else {
                last?.next = node
                last = node
            }
            return this
        }
    }
}