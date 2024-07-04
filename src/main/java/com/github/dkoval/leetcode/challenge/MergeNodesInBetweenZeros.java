package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/problems/merge-nodes-in-between-zeros/">Merge Nodes in Between Zeros</a>
 * <p>
 * You are given the head of a linked list, which contains a series of integers separated by 0's.
 * The beginning and end of the linked list will have Node.val == 0.
 * <p>
 * For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value
 * is the sum of all the merged nodes. The modified list should not contain any 0's.
 * <p>
 * Return the head of the modified linked list.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the list is in the range [3, 2 * 10^5].</li>
 *  <li>0 <= Node.val <= 1000</li>
 *  <li>There are no two consecutive nodes with Node.val == 0</li>
 *  <li>The beginning and end of the linked list have Node.val == 0</li>
 * </ul>
 */
public interface MergeNodesInBetweenZeros {

    ListNode mergeNodes(ListNode head);

    // O(N) time | O(1) space
    class MergeNodesInBetweenZerosRev1 implements MergeNodesInBetweenZeros {

        @Override
        public ListNode mergeNodes(ListNode head) {
            // The beginning and end of the linked list have Node.val == 0
            ListNode lastZero = head;
            // The number of nodes in the list >= 3
            ListNode curr = head.next;
            while (curr != null) {
                int sum = 0;
                while (curr.val != 0) {
                    sum += curr.val;
                    curr = curr.next;
                }
                lastZero.val = sum;
                lastZero.next = (curr.next != null) ? curr : null;
                lastZero = lastZero.next;
                curr = curr.next;
            }
            return head;
        }
    }
}
