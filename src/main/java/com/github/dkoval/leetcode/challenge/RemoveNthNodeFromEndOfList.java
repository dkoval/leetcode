package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3712/">Remove Nth Node From End of List</a>
 * <p>
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * Follow up: Could you do this in one pass?
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30.
 * 0 <= Node.val <= 100.
 * 1 <= n <= sz.
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null, slow = head, fast = head;
        // advance `fast` pointer by n steps
        while (n-- > 0) {
            fast = fast.next;
        }
        // now, keep on shifting `slow` and `fast `pointers until `fast` reaches the end of the list
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        // finally, remove n-th node from the end of the list
        if (prev == null) {
            // corner case: 1st node of the list is to be removed
            return head.next;
        } else {
            prev.next = slow.next;
            return head;
        }
    }
}
