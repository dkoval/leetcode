package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/">Convert Binary Number in a Linked List to Integer</a>
 * <p>
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1.
 * The linked list holds the binary representation of a number.
 * <p>
 * Return the decimal value of the number in the linked list.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The Linked List is not empty.</li>
 *  <li>Number of nodes will not exceed 30.</li>
 *  <li>Each node's value is either 0 or 1.</li>
 * </ul>
 */
public interface ConvertBinaryNumberInLinkedListToInteger {

    int getDecimalValue(ListNode head);

    // O(N) time | O(1) space
    class ConvertBinaryNumberInLinkedListToIntegerRev1 implements ConvertBinaryNumberInLinkedListToInteger {

        @Override
        public int getDecimalValue(ListNode head) {
            int x = 0;
            ListNode curr = head;
            while (curr != null) {
                int digit = curr.val;
                x = x * 2 + digit;
                curr = curr.next;
            }
            return x;
        }
    }

    // O(N) time | O(1) space
    class ConvertBinaryNumberInLinkedListToIntegerRev2 implements ConvertBinaryNumberInLinkedListToInteger {

        @Override
        public int getDecimalValue(ListNode head) {
            var curr = head;
            var x = 0;
            while (curr != null) {
                x <<= 1;
                x |= curr.val;
                curr = curr.next;
            }
            return x;
        }
    }
}
