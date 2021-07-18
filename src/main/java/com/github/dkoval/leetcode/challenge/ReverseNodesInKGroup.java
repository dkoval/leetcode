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
        ListNode start = head;
        ListNode curr = head;
        ListNode dummy = new ListNode(42), prevGroupEnd = dummy;
        int count = 0;

        while (curr != null) {
            count++;
            ListNode next = curr.next;
            if (count == k) {
                reverse(start, curr);
                prevGroupEnd.next = curr;
                start.next = next;
                prevGroupEnd = start;
                start = next;
                count = 0;
            }
            curr = next;
        }
        return dummy.next;
    }

    private void reverse(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode curr = start;
        ListNode stop = end.next;
        while (curr != stop) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}
