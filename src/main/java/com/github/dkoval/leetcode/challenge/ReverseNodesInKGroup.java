package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3818/">Reverse Nodes in k-Group</a>
 * <p>
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * <p>
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 */
public class ReverseNodesInKGroup {

    // O(N) time | O(1) space
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy; // points to the last node of the previous group

        ListNode start = head; // points to the first node of the current group
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            ListNode next = curr.next;
            if (count == k) {
                // reverse next k nodes of the list
                reverse(start, curr);

                // at this stage,
                // `curr` points to the first node of the current group
                // `start` points to the last node of the current group

                // point the last node of the previous group to the first node of the current group
                prev.next = curr;
                // point the last node of the current group to `next`
                start.next = next;

                // prepare for the next iteration
                prev = start;
                start = next;
                count = 0;
            }
            curr = next;
        }
        return dummy.next;
    }

    private void reverse(ListNode start, ListNode end) {
        ListNode curr = start;
        ListNode prev = null;
        ListNode stop = end.next;
        while (curr != stop) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}
