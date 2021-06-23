package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3789/">Reverse Linked List II</a>
 * <p>
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the list is n</li>
 *  <li>1 <= n <= 500</li>
 *  <li>-500 <= Node.val <= 500</li>
 *  <li>1 <= left <= right <= n</li>
 * </ul>
 * <p>
 * Follow up: Could you do it in one pass?
 */
public class ReverseLinkedList2 {

    // O(N) time | O(1) space
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int idx = 1;
        ListNode curr = head;

        // find left node
        ListNode prevToLeftNode = null;
        while (curr != null && idx != left) {
            prevToLeftNode = curr;
            curr = curr.next;
            idx++;
        }
        ListNode leftNode = curr;

        // find right node
        while (curr != null && idx != right) {
            curr = curr.next;
            idx++;
        }
        ListNode rightNode = curr;
        ListNode nextToRightNode = curr.next;

        // reverse the sub-list between left and right pointers
        ListNode prev = nextToRightNode;
        curr = leftNode;
        while (curr != nextToRightNode) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // reversed list head
        if (prevToLeftNode != null) {
            prevToLeftNode.next = prev;
            return head;
        } else {
            return prev;
        }
    }
}
