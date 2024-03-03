package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">Remove Nth Node From End of List</a>
 * <p>
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * Follow up: Could you do this in one pass?
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the list is sz.</li>
 *  <li>1 <= sz <= 30.</li>
 *  <li>0 <= Node.val <= 100.</li>
 *  <li>1 <= n <= sz.</li>
 * </ul>
 */
public interface RemoveNthNodeFromEndOfList {

    ListNode removeNthFromEnd(ListNode head, int n);

    // O(N) time | O(1) space
    class RemoveNthNodeFromEndOfListRev1 implements RemoveNthNodeFromEndOfList {

        @Override
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // advance `fast` pointer by n steps forward
            ListNode fast = head;
            while (n-- > 0) {
                fast = fast.next;
            }

            // now, keep on shifting `slow` and `fast `pointers until `fast` reaches the end of the list;
            // at the time `fast` reaches the end of the list, `slow` will point at the n-th node from the end of the list
            ListNode slow = head;
            ListNode prev = null;
            while (fast != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next;
            }

            // finally, remove n-th node from the end of the list
            if (prev != null) {
                prev.next = slow.next;
                return head;
            }
            // corner case: 1st node of the list is to be removed
            return head.next;
        }
    }
}
