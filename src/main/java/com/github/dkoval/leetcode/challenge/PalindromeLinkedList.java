package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/palindrome-linked-list/">Palindrome Linked List</a>
 * <p>
 * Given the head of a singly linked list, return true if it is a palindrome.
 * <p>
 * Follow up: Could you do it in O(n) time and O(1) space?
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the list is in the range [1, 10^5]</li>
 *  <li>0 <= Node.val <= 9</li>
 * </ul>
 */
public interface PalindromeLinkedList {

    boolean isPalindrome(ListNode head);

    // O(N) time | O(N) space
    class PalindromeLinkedListUsingExtraSpace implements PalindromeLinkedList {

        @Override
        public boolean isPalindrome(ListNode head) {
            List<Integer> list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            int n = list.size();
            for (int i = 0; i < n / 2; i++) {
                if (!list.get(i).equals(list.get(n - i - 1))) {
                    return false;
                }
            }
            return true;
        }
    }

    // O(N) time | O(1) space
    class PalindromeLinkedListFollowUp implements PalindromeLinkedList {

        @Override
        public boolean isPalindrome(ListNode head) {
            // find the middle node of the list
            ListNode curr1 = head;
            ListNode curr2 = head;
            while (curr1 != null && curr1.next != null) {
                curr1 = curr1.next.next;
                curr2 = curr2.next;
            }

            // split the list into 2 halves, then reverse 2nd half
            curr1 = head;
            curr2 = reverse(curr2);

            // Note that 2nd half contains as many elements as the 1st half if the length of the list is even,
            // or is exactly one element less if the length of the list is odd
            while (curr2 != null) {
                if (curr1.val != curr2.val) {
                    return false;
                }
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
            return true;
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
