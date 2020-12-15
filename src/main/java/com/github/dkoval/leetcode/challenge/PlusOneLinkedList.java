package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/571/week-3-december-15th-december-21st/3566/">Plus One Linked List</a>
 * <p>
 * Given a non-negative integer represented as a linked list of digits, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOneLinkedList {

    public ListNode plusOne(ListNode head) {
        ListNode reversed = reverse(head);
        ListNode curr = reversed;
        while (curr != null) {
            if (curr.val < 9) {
                curr.val++;
                break;
            } else {
                curr.val = 0;
            }
            curr = curr.next;
        }
        ListNode newHead = reverse(reversed);
        if (newHead.val == 0) {
            ListNode node = new ListNode(1);
            node.next = newHead;
            newHead = node;
        }
        return newHead;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
