package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/explore/featured/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3693/">Palindrome Linked List</a>
 * <p>
 * Given the head of a singly linked list, return true if it is a palindrome.
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
}
