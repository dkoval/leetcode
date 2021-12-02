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

    // O(N) time | O(1) space
    fun oddEvenList(head: ListNode?): ListNode? {
        val dummyHeadOdd = ListNode(-1)
        var currOdd = dummyHeadOdd

        val dummyHeadEven = ListNode(-1)
        var currEven = dummyHeadEven

        var curr = head
        var odd = true
        while (curr != null) {
            val next = curr.next
            if (odd) {
                currOdd.next = curr
                currOdd = currOdd.next!!
            } else {
                currEven.next = curr
                currEven = currEven.next!!
            }
            curr.next = null
            odd = !odd
            curr = next
        }

        currOdd.next = dummyHeadEven.next
        return dummyHeadOdd.next
    }
}