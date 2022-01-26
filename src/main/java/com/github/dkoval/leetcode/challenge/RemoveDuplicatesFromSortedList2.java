package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3593/">Remove Duplicates from Sorted List II</a>
 * <p>
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list. Return the linked list sorted as well.
 */
public interface RemoveDuplicatesFromSortedList2 {

    ListNode deleteDuplicates(ListNode head);

    // O(N) time | O(1) space
    class RemoveDuplicatesFromSortedList2Rev1 implements RemoveDuplicatesFromSortedList2 {

        @Override
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(101, head);
            ListNode last = dummy; // points to the last unique node in the resulting list
            ListNode curr = head;  // points to the current node
            while (curr != null) {
                if (curr.next != null && curr.next.val == curr.val) {
                    // skip over duplicates
                    while (curr.next != null && curr.next.val == curr.val) {
                        curr = curr.next;
                    }
                    // remove duplicates
                    last.next = curr.next;
                } else {
                    last = curr;
                }
                curr = curr.next;
            }
            return dummy.next;
        }
    }

    // O(N) time | O(1) space
    class RemoveDuplicatesFromSortedList2Rev2 implements RemoveDuplicatesFromSortedList2 {

        @Override
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(101, head);
            ListNode last = dummy; // points to the last unique node in the resulting list
            ListNode curr = head;  // points to the current node
            while (curr != null) {
                if (curr.next != null && curr.next.val == curr.val) {
                    // skip over duplicates
                    ListNode prev = curr;
                    curr = curr.next;
                    while (curr != null && curr.val == prev.val) {
                        prev = curr;
                        curr = curr.next;
                    }
                    // remove duplicates
                    last.next = curr;
                } else {
                    last = curr;
                    curr = curr.next;
                }
            }
            return dummy.next;
        }
    }
}
