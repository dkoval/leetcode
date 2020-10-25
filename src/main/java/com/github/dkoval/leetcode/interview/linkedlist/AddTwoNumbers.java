package com.github.dkoval.leetcode.interview.linkedlist;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/783/">Add Two Numbers</a>
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
 * and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(42), prev = dummy;
        ListNode p1 = l1, p2 = l2;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int sum = carry;
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            int digit = sum % 10;
            carry = sum / 10;
            ListNode curr = new ListNode(digit);
            prev.next = curr;
            prev = curr;
        }
        if (carry == 1) {
            prev.next = new ListNode(1);
        }
        return dummy.next;
    }
}
