package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3486/">Rotate List</a>
 * <p>
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 */
public class RotateList {

    private static class ListInfo {
        final ListNode tail;
        final int size;

        ListInfo(ListNode tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListInfo info = info(head);
        k %= info.size;

        if (k == 0) {
            return head;
        }

        // skip first (n - k - 1) nodes
        ListNode curr = head;
        int skip = info.size - k - 1;
        while (skip-- > 0) {
            curr = curr.next;
        }

        ListNode newHead = curr.next;
        curr.next = null;
        info.tail.next = head;
        return newHead;
    }

    private ListInfo info(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        int size = 0;
        while (curr != null) {
            size++;
            prev = curr;
            curr = curr.next;
        }
        return new ListInfo(prev, size);
    }
}
