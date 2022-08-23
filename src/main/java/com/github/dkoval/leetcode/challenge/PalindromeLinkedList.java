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
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null)  {
                slow = slow.next;
                fast = fast.next.next;
            }

            // split the list into 2 halves
            ListNode curr1 = head;
            ListNode curr2 = slow;

            // reverse the 2nd half of the list
            curr2 = reverse(curr2);

            while (curr1 != null && curr2 != null) {
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
