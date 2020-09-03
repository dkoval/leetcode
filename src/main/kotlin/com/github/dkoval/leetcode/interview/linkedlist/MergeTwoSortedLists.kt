package com.github.dkoval.leetcode.interview.linkedlist

import com.github.dkoval.leetcode.ListNode

/**
 * [Merge Two Sorted Lists](https://leetcode.com/explore/featured/card/top-interview-questions-easy/93/linked-list/771/)
 *
 * Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
 */
interface MergeTwoSortedLists {

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode?
}

object MergeTwoSortedListsIter : MergeTwoSortedLists {

    override fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) return l2
        if (l2 == null) return l1
        var currL1 = l1
        var currL2 = l2
        val dummy = ListNode(Int.MIN_VALUE)
        var curr = dummy
        // iterate over the shorter list
        while (currL1 != null && currL2 != null) {
            if (currL1.`val` < currL2.`val`) {
                curr.next = ListNode(currL1.`val`)
                currL1 = currL1.next
            } else {
                curr.next = ListNode(currL2.`val`)
                currL2 = currL2.next
            }
            curr = curr.next!!
        }
        // if l1 is larger, append remaining elements to the result
        while (currL1 != null) {
            curr.next = ListNode(currL1.`val`)
            curr = curr.next!!
            currL1 = currL1.next
        }
        // if l2 is larger, append remaining elements to the result
        while (currL2 != null) {
            curr.next = ListNode(currL2.`val`)
            curr = curr.next!!
            currL2 = currL2.next
        }
        return dummy.next
    }
}

object MergeTwoSortedListsRecursive : MergeTwoSortedLists {

    override fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) return l2
        if (l2 == null) return l1
        return if (l1.`val` < l2.`val`) {
            l1.next = mergeTwoLists(l1.next, l2)
            l1
        } else {
            l2.next = mergeTwoLists(l1, l2.next)
            l2
        }
    }
}