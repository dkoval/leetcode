package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3707/">Partition List</a>
 * <p>
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the list is in the range [0, 200].</li>
 *  <li>-100 <= Node.val <= 100</li>
 *  <li>-200 <= x <= 200</li>
 * </ul>
 */
public class PartitionList {

    // O(N) time | O(1) space
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode p1Head = new ListNode(-1), p1 = p1Head;
        ListNode p2Head = new ListNode(-1), p2 = p2Head;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = null;
            if (curr.val < x) {
                p1.next = curr;
                p1 = p1.next;
            } else {
                p2.next = curr;
                p2 = p2.next;
            }
            curr = next;
        }
        if (p1 != p1Head) {
            p1.next = p2Head.next;
            return p1Head.next;
        } else {
            return p2Head.next;
        }
    }
}
