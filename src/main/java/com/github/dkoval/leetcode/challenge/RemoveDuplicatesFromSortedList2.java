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
        ListNode dummy = new ListNode(0, head);
        ListNode lastDistinct = dummy, curr = head;
        while (curr != null) {
            if (curr.next != null && curr.next.val == curr.val) {
                // skip duplicates
                while (curr.next != null && curr.next.val == curr.val) {
                    curr = curr.next;
                }
                lastDistinct.next = curr.next;
            } else {
                lastDistinct = lastDistinct.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
