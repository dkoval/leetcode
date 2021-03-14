package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3671/">Swapping Nodes in a Linked List</a>
 * <p>
 * You are given the head of a linked list, and an integer k.
 * <p>
 * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node
 * from the end (the list is 1-indexed).
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the list is n.</li>
 *  <li>1 <= k <= n <= 105</li>
 *  <li>0 <= Node.val <= 100</li>
 * </ul>
 */
public class SwappingNodesInLinkedList {

    // O(N) time | O(1) space
    public ListNode swapNodes(ListNode head, int k) {
        ListNode p1 = head;
        while (--k > 0) {
            p1 = p1.next;
        }
        ListNode p2 = head, curr = p1;
        while (curr.next != null) {
            p2 = p2.next;
            curr = curr.next;
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
