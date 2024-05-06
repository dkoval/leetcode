package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/problems/remove-nodes-from-linked-list/">Remove Nodes From Linked List</a>
 * <p>
 * You are given the head of a linked list.
 * <p>
 * Remove every node which has a node with a greater value anywhere to the right side of it.
 * <p>
 * Return the head of the modified linked list.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of the nodes in the given list is in the range [1, 10^5]</li>
 *  <li>1 <= Node.val <= 10^5</li>
 * </ul>
 */
public interface RemoveNodesFromLinkedList {

    ListNode removeNodes(ListNode head);

    class RemoveNodesFromLinkedListRev1 implements RemoveNodesFromLinkedList {

        @Override
        public ListNode removeNodes(ListNode head) {
            // idea: while iterating in the reversed order,
            // record the maximum node.val that has been seen so far;
            // if the current node.val < max, then remove the current node.
            head = reverse(head);

            int max = Integer.MIN_VALUE;
            ListNode curr = head;
            ListNode prev = null;
            while (curr != null) {
                max = Math.max(max, curr.val);
                if (curr.val < max) {
                    prev.next = curr.next;
                } else {
                    prev = curr;
                }
                curr = curr.next;
            }
            return reverse(head);
        }

        private ListNode reverse(ListNode head) {
            ListNode curr = head;
            ListNode prev = null;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }
}
