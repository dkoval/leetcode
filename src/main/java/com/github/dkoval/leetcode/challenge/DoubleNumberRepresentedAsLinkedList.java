package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/">Double a Number Represented as a Linked List</a>
 * <p>
 * You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.
 * <p>
 * Return the head of the linked list after doubling it.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the list is in the range [1, 10^4]</li>
 *  <li>0 <= Node.val <= 9</li>
 *  <li>The input is generated such that the list represents a number that does not have leading zeros, except the number 0 itself.</li>
 * </ul>
 */
public interface DoubleNumberRepresentedAsLinkedList {

    ListNode doubleIt(ListNode head);

    class DoubleNumberRepresentedAsLinkedListRev1 implements DoubleNumberRepresentedAsLinkedList {

        @Override
        public ListNode doubleIt(ListNode head) {
            head = reverse(head);

            ListNode curr = head;
            ListNode prev = null;
            int carry = 0;
            while (curr != null) {
                int x = 2 * curr.val + carry;
                curr.val = x % 10;
                carry = x / 10;

                prev = curr;
                curr = curr.next;
            }

            // corner case: 999 * 2 = 1998
            if (carry > 0) {
                prev.next = new ListNode(carry);
            }

            return reverse(head);
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
