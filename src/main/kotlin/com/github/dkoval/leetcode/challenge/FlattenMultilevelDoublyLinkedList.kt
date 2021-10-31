package com.github.dkoval.leetcode.challenge

import java.util.*

class Node(var `val`: Int) {
    var prev: Node? = null
    var next: Node? = null
    var child: Node? = null
}

fun Node?.toList(): List<Int> {
    val result = LinkedList<Int>()
    var curr = this
    while (curr != null) {
        result.add(curr.`val`)
        curr = curr.next
    }
    return result
}

/**
 * [Flatten a Multilevel Doubly Linked List](https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/)
 *
 * You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer,
 * which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own,
 * and so on, to produce a multilevel data structure.
 *
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list.
 * You are given the head of the first level of the list.
 *
 * Constraints:
 * - The number of Nodes will not exceed 1000
 * - 1 <= Node.val <= 10^5
 */
object FlattenMultilevelDoublyLinkedList {

    fun flatten(root: Node?): Node? = root?.also { flattenRecursive(it) }

    // Recursively flattens a list and returns its last non-null node
    private fun flattenRecursive(root: Node): Node {
        var curr: Node? = root
        var last = root
        while (curr != null) {
            val child = curr.child
            val next = curr.next
            if (child != null) {
                curr.next = child
                child.prev = curr
                curr.child = null

                last = flattenRecursive(child)
                last.next = next
                if (next != null) {
                    next.prev = last
                }
            } else {
                last = curr
            }
            curr = next
        }
        return last
    }
}