package com.github.dkoval.leetcode

import java.util.*

class ListNode @JvmOverloads constructor(
    @JvmField var `val`: Int,
    @JvmField var next: ListNode? = null
) {
    companion object {
        fun headOf(vararg nums: Int): ListNode? {
            if (nums.isEmpty()) {
                return null
            }

            val dummy = ListNode(42)
            var curr = dummy
            for (x in nums) {
                curr.next = ListNode(x)
                curr = curr.next!!
            }
            return dummy.next
        }
    }
}

fun ListNode?.equalsTo(that: ListNode?): Boolean {
    var curr1 = this
    var curr2 = that
    while (curr1 != null && curr2 != null) {
        if (curr1.`val` != curr2.`val`) {
            return false;
        }
        curr1 = curr1.next
        curr2 = curr2.next
    }
    return (curr1 == null) && (curr2 == null)
}

fun ListNode?.findFirst(`val`: Int): ListNode? {
    var curr = this
    while (curr != null) {
        if (curr.`val` == `val`) {
            return curr
        }
        curr = curr.next
    }
    return null
}

fun ListNode?.dump(): List<Int> {
    val dump = LinkedList<Int>()
    var curr = this
    while (curr != null) {
        dump += curr.`val`
        curr = curr.next
    }
    return dump
}