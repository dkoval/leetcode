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
        ListNode dummy = new ListNode(42), curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            int digit = sum % 10;
            carry = sum / 10;
            curr.next = new ListNode(digit);
            curr = curr.next;
        }
        if (carry == 1) {
            curr.next = new ListNode(1);
        }
        return dummy.next;
    }
}
