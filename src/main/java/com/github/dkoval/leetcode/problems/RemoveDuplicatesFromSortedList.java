package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/">Remove Duplicates from Sorted List</a>
 * <p>
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the list is in the range [0, 300]</li>
 *  <li>-100 <= Node.val <= 100</li>
 *  <li>The list is guaranteed to be sorted in ascending order</li>
 * </ul>
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode prev = head;
        while (curr != null) {
            if (curr.val != prev.val) {
                prev = curr;
            } else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }
        return head;
    }
}
