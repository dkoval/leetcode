package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/problems/reverse-nodes-in-even-length-groups/">Reverse Nodes in Even Length Groups</a>
 * <p>
 * You are given the head of a linked list.
 * <p>
 * The nodes in the linked list are sequentially assigned to non-empty groups whose lengths form the sequence of the natural numbers (1, 2, 3, 4, ...).
 * The length of a group is the number of nodes assigned to it. In other words,
 * <ul>
 *  <li>The 1st node is assigned to the first group.</li>
 *  <li>The 2nd and the 3rd nodes are assigned to the second group.</li>
 *  <li>The 4th, 5th, and 6th nodes are assigned to the third group, and so on.</li>
 * </ul>
 * Note that the length of the last group may be less than or equal to 1 + the length of the second to last group.
 * <p>
 * Reverse the nodes in each group with an even length, and return the head of the modified linked list.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the list is in the range [1, 10^5]</li>
 *  <li>0 <= Node.val <= 10^5</li>
 * </ul>
 */
public class ReverseNodesInEvenLengthGroups {

    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy; // points to the last node of the previous group
        ListNode start = head; // points to the first node of the current group
        ListNode curr = head;
        int length = 1;
        while (curr != null) {
            // try to advance `curr` pointer `length` steps forward
            int count = 1;
            while (curr.next != null && count != length) {
                count++;
                curr = curr.next;
            }

            ListNode next = curr.next;
            if (count % 2 == 0) {
                reverse(start, curr);

                // at this stage:
                //  ... prev -> | curr -> ... -> start | -> next
                prev.next = curr;
                start.next = next;
                prev = start;

            } else {
                prev = curr;
            }

            length++;
            start = next;
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
