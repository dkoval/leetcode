package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/problems/insertion-sort-list/">Insertion Sort List</a>
 * <p>
 * Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.
 * <p>
 * The steps of the insertion sort algorithm:
 * <p>
 * Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
 * It repeats until no input elements remain.
 * The following is a graphical example of the insertion sort algorithm.
 * The partially sorted list (black) initially contains only the first element in the list.
 * One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the list is in the range [1, 5000]</li>
 *  <li>-5000 <= Node.val <= 5000</li>
 * </ul>
 */
public class InsertionSortList {

    // O(N^2) time | O(1) space
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        // at each iteration, check if the following invariant holds:
        // curr.val <= next.val
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val <= curr.next.val) {
                curr = curr.next;
            } else {
                ListNode insert = curr.next;
                // locate the node previous to the one that needs to be inserted
                ListNode preInsert = dummy;
                while (preInsert.next.val < insert.val) {
                    preInsert = preInsert.next;
                }
                // update pointers
                curr.next = insert.next;
                insert.next = preInsert.next;
                preInsert.next = insert;
            }
        }
        return dummy.next;
    }
}
