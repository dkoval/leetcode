package com.github.dkoval.leetcode

import java.util.*

class ListNode(@JvmField var `val`: Int) {
    @JvmField
    var next: ListNode? = null
}

fun ListNode?.find(value: Int): ListNode? {
    var curr = this
    while (curr != null) {
        if (curr.`val` == value) {
            return curr
        }
        curr = curr.next
    }
    return null
}

fun ListNode?.toList(): List<Int> {
    val result = LinkedList<Int>()
    var curr = this
    while (curr != null) {
        result.add(curr.`val`)
        curr = curr.next
    }
    return result
}