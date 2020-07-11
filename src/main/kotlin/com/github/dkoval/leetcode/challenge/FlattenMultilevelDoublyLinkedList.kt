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

    fun flatten(root: Node?): Node? = root?.also { flattenRecursive(it) }

    // Recursively flattens a list and returns its tail
    private fun flattenRecursive(root: Node): Node {
        var curr: Node? = root
        var tail = root
        while (curr != null) {
            val child = curr.child
            val next = curr.next
            if (child == null) {
                curr = next
            } else {
                curr.next = child
                child.prev = curr
                curr.child = null
                tail = flattenRecursive(child)
                tail.next = next
                next?.also { it.prev = tail }
                curr = tail
            }
            curr?.also { tail = it } // make sure tail is never null while advancing curr
        }
        return tail
    }
}