package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/merge-k-sorted-lists/">Merge k Sorted Lists (Hard)</a>
 * <p>
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * Constraints:
 * <ul>
 *  <li>k == lists.length</li>
 *  <li>0 <= k <= 10^4</li>
 *  <li>0 <= lists[i].length <= 500</li>
 *  <li>-10^4 <= lists[i][j] <= 10^4</li>
 *  <li>lists[i] is sorted in ascending order</li>
 *  <li>The sum of lists[i].length won't exceed 10^4</li>
 * </ul>
 */
public class MergeKSortedLists {

    // Resource: https://www.youtube.com/watch?v=QG7AVdPbgb4
    // O(N * logK) time | O(K) space
    public ListNode mergeKLists(ListNode[] lists) {
        // Min heap is used to take min of at most k values
        Queue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        if (minHeap.isEmpty()) {
            return null;
        }

        ListNode dummy = new ListNode(10001);
        ListNode curr = dummy;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            if (node.next != null) {
                minHeap.offer(node.next);
            }
            // append next node to the merged list
            curr.next = node;
            curr = curr.next;
        }
        return dummy.next;
    }
}
