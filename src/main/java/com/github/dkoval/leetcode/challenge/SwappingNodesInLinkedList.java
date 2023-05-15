package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/problems/swapping-nodes-in-a-linked-list/description/">Swapping Nodes in a Linked List</a>
 * <p>
 * You are given the head of a linked list, and an integer k.
 * <p>
 * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node
 * from the end (the list is 1-indexed).
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the list is n.</li>
 *  <li>1 <= k <= n <= 10^5</li>
 *  <li>0 <= Node.val <= 100</li>
 * </ul>
 */
public class SwappingNodesInLinkedList {

    // O(N) time | O(1) space
    public ListNode swapNodes(ListNode head, int k) {
        // first k-th node
        ListNode p1 = head;
        while (--k > 0) {
            p1 = p1.next;
        }

        // last k-th node
        ListNode p2 = head, curr = p1;
        while (curr.next != null) {
            curr = curr.next;
            p2 = p2.next;
        }

        swapValues(p1, p2);
        return head;
    }

    private void swapValues(ListNode p1, ListNode p2) {
        if (p1 == p2) return;
        int tmp = p1.val;
        p1.val = p2.val;
        p2.val = tmp;
    }
}
