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

object FlattenMultilevelDoublyLinkedList {

    fun flatten(root: Node?): Node? {
        if (root != null) {
            doFlatten(root)
        }
        return root
    }

    // Recursively flattens a list and returns its tail
    private fun doFlatten(root: Node): Node {
        var curr: Node? = root
        var tail = root
        while (curr != null) {
            val child = curr.child
            val next = curr.next
            if (child != null) {
                val interimTail = doFlatten(child)
                interimTail.next = next
                if (next != null) {
                    next.prev = interimTail
                }
                curr.next = child
                child.prev = curr
                curr.child = null
                curr = tail
            } else {
                curr = next
            }
            if (curr != null) {
                tail = curr
            }
        }
        return tail
    }
}