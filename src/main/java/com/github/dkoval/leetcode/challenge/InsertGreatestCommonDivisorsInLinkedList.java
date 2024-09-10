package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/">Insert Greatest Common Divisors in Linked List</a>
 * <p>
 * Given the head of a linked list head, in which each node contains an integer value.
 * <p>
 * Between every pair of adjacent nodes, insert a new node with a value equal to the greatest common divisor of them.
 * <p>
 * Return the linked list after insertion.
 * <p>
 * The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the list is in the range [1, 5000]</li>
 *  <li>1 <= Node.val <= 1000</li>
 * </ul>
 */
public interface InsertGreatestCommonDivisorsInLinkedList {

    ListNode insertGreatestCommonDivisors(ListNode head);

    // O(N) time | O(1) space
    class InsertGreatestCommonDivisorsInLinkedListRev1 implements InsertGreatestCommonDivisorsInLinkedList {

        @Override
        public ListNode insertGreatestCommonDivisors(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode prev = head;
            ListNode curr = head.next;
            while (curr != null) {
                prev.next = new ListNode(gcd(prev.val, curr.val), curr);
                prev = curr;
                curr = curr.next;
            }
            return head;
        }

        private int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }
    }

    // O(N) time | O(1) space
    class InsertGreatestCommonDivisorsInLinkedListRev2 implements InsertGreatestCommonDivisorsInLinkedList {

        @Override
        public ListNode insertGreatestCommonDivisors(ListNode head) {
            ListNode curr = head;
            while (curr != null && curr.next != null) {
                ListNode next = curr.next;
                curr.next = new ListNode(gcd(curr.val, next.val), next);
                curr = next;
            }
            return head;
        }

        private int gcd(int a, int b) {
            while (b > 0) {
                int oldA = a;
                a = b;
                b = oldA % b;
            }
            return a;
        }
    }
}
