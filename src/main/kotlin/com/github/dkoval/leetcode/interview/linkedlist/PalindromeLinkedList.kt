package com.github.dkoval.leetcode.interview.linkedlist

import com.github.dkoval.leetcode.ListNode
import com.github.dkoval.leetcode.challenge.PalindromeLinkedList

// Time complexity: O(N), space complexity: O(N)
object PalindromeLinkedListUsingExtraSpaceKt : PalindromeLinkedList {

    override fun isPalindrome(head: ListNode?): Boolean {
        var curr1 = head
        // create a new in reverse order, then compare each node
        var curr2 = reverse(head)
        while (curr1 != null && curr2 != null) {
            if (curr1.`val` != curr2.`val`) return false
            curr1 = curr1.next
            curr2 = curr2.next
        }
        return true
    }

    private fun reverse(head: ListNode?): ListNode? {
        var curr = head
        var reversed: ListNode? = null
        while (curr != null) {
            val tmp = ListNode(curr.`val`)
            tmp.next = reversed
            reversed = tmp
            curr = curr.next
        }
        return reversed
    }
}

// Time complexity: O(N), space complexity: O(1)
object PalindromeLinkedListBreakAndReverseSecondHalf : PalindromeLinkedList {

    override fun isPalindrome(head: ListNode?): Boolean {
        if (head?.next == null) return true
        var fast = head
        var slow = head
        while (fast?.next?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
        }
        val head2 = slow?.next // head of the second half
        slow?.next = null // unlink first and second halves
        var curr1 = head
        var curr2 = reverseInPlace(head2)
        while (curr1 != null && curr2 != null) {
            if (curr1.`val` != curr2.`val`) return false
            curr1 = curr1.next
            curr2 = curr2.next
        }
        return true
    }

    private fun reverseInPlace(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr = head
        while (curr != null) {
            val next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }
        return prev
    }
}