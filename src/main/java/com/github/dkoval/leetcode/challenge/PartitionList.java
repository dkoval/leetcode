package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/problems/partition-list/">Partition List</a>
 * <p>
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the list is in the range [0, 200]</li>
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

        // partition 1 - nodes less than x
        ListNode dummy1 = new ListNode(-101);
        ListNode curr1 = dummy1;

        // partition 2 - nodes greater than or equal to x
        ListNode dummy2 = new ListNode(101);
        ListNode curr2 = dummy2;

        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            if (curr.val < x) {
                curr1.next = curr;
                curr1 = curr1.next;
            } else {
                curr2.next = curr;
                curr2 = curr2.next;
            }
            curr.next = null;
            curr = next;
        }

        curr1.next = dummy2.next;
        return dummy1.next;
    }
}
