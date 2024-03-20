package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/problems/merge-in-between-linked-lists/">Merge In Between Linked Lists</a>
 * <p>
 * You are given two linked lists: list1 and list2 of sizes n and m respectively.
 * <p>
 * Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
 * <p>
 * Build the result list and return its head.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= list1.length <= 10^4</li>
 *  <li>1 <= a <= b < list1.length - 1</li>
 *  <li>1 <= list2.length <= 104</li>
 * </ul>
 */
public interface MergeInBetweenLinkedLists {

    ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2);

    class MergeInBetweenLinkedListsRev1 implements MergeInBetweenLinkedLists {

        @Override
        public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
            int i = 0;
            ListNode start1 = list1;
            while (i < a - 1) {
                start1 = start1.next;
                i++;
            }

            ListNode end1 = start1;
            while (i < b) {
                end1 = end1.next;
                i++;
            }

            ListNode end2 = list2;
            while (end2 != null && end2.next != null) {
                end2 = end2.next;
            }

            start1.next = list2;
            end2.next = end1.next;
            end1.next = null; // optional

            return list1;
        }
    }
}
