package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3593/">Remove Duplicates from Sorted List II</a>
 * <p>
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list. Return the linked list sorted as well.
 */
public class RemoveDuplicatesFromSortedList2 {

    // O(N) time | O(1) space
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode prev = null; // points to the last distinct node
        while (curr != null) {
            if (curr.next != null && curr.next.val == curr.val) {
                // skip over duplicates
                while (curr.next != null && curr.next.val == curr.val) {
                    curr = curr.next;
                }
                // remove duplicates
                if (prev != null) {
                    prev.next = curr.next;
                } else {
                    head = curr.next;
                }
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
