package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/explore/featured/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3693/">Palindrome Linked List</a>
 * <p>
 * Given the head of a singly linked list, return true if it is a palindrome.
 * <p>
 * Follow up: Could you do it in O(n) time and O(1) space?
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
            // find mid of the list
            ListNode mid = head, fast = head;
            while (fast != null && fast.next != null && fast.next.next != null) {
                mid = mid.next;
                fast = fast.next.next;
            }

            // split the list in 2 halves
            ListNode l1 = head;
            ListNode l2 = mid.next;

            // reverse either 1st or 2nd half
            l2 = reverse(l2);

            while (l1 != null && l2 != null) {
                if (l1.val != l2.val) {
                    return false;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            return true;
        }

        private ListNode reverse(ListNode head) {
            ListNode curr = head, prev = null;
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
