package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/">Delete the Middle Node of a Linked List</a>
 * <p>
 * You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
 * <p>
 * The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing,
 * where ⌊x⌋ denotes the largest integer less than or equal to x.
 * <p>
 * For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the list is in the range [1, 10^5].</li>
 *  <li>1 <= Node.val <= 10^5</li>
 * </ul>
 */
public interface DeleteMiddleNodeOfLinkedList {

    ListNode deleteMiddle(ListNode head);

    // O(N) time | O(1) space
    class DeleteMiddleNodeOfLinkedListRev1 implements DeleteMiddleNodeOfLinkedList {

        @Override
        public ListNode deleteMiddle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            ListNode prev = null;
            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            if (prev != null) {
                prev.next = slow.next;
            } else {
                head = head.next;
            }
            return head;
        }
    }
}
