package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3486/">Rotate List</a>
 * <p>
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode slow = head, fast = head;
        int length = 1;
        while (fast.next != null) {
            fast = fast.next;
            length++;
        }
        if (k % length == 0) {
            return head;
        }
        int m = length - k % length - 1;
        while (m-- > 0) {
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}
