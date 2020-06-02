package com.github.dkoval.leetcode.challenge

import com.github.dkoval.leetcode.ListNode

/**
 * [Delete Node in a Singly-Linked List](https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3348/)
 *
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 */
object DeleteNodeInSinglyLinkedList {

    fun deleteNode(node: ListNode?) {
        // the node to delete can't be the last one in the list
        if (node?.next == null) {
            return
        }
        // copy the value of the next node to the given node
        node.`val` = node.next!!.`val`
        // point the given node to its successor's next node (effectively delete the given node successor)
        node.next = node.next!!.next
    }
}