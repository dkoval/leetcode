package com.github.dkoval.leetcode

import java.util.*

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun ListNode?.toList(): List<Int> {
    val result = LinkedList<Int>()
    var current = this
    while (current != null) {
        result.add(current.`val`)
        current = current.next
    }
    return result
}