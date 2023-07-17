package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers-ii/">Add Two Numbers II</a>
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in each linked list is in the range [1, 100].</li>
 *  <li>0 <= Node.val <= 9</li>
 *  <li>It is guaranteed that the list represents a number that does not have leading zeros.</li>
 * </ul>
 */
public interface AddTwoNumbers2 {

    ListNode addTwoNumbers(ListNode l1, ListNode l2);

    class AddTwoNumbers2Rev1 implements AddTwoNumbers2 {

        @Override
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode x1 = reverse(l1);
            ListNode x2 = reverse(l2);

            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;
            int carry = 0;
            while (x1 != null || x2 != null) {
                int sum = carry;

                if (x1 != null) {
                    sum += x1.val;
                    x1 = x1.next;
                }

                if (x2 != null) {
                    sum += x2.val;
                    x2 = x2.next;
                }

                int digit = sum % 10;
                carry = sum / 10;

                curr.next = new ListNode(digit);
                curr = curr.next;
            }

            if (carry > 0) {
                curr.next = new ListNode(carry);
            }

            return reverse(dummy.next);
        }

        private ListNode reverse(ListNode head) {
            ListNode curr = head;
            ListNode prev = null;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }
}
