package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/">Remove Zero Sum Consecutive Nodes from Linked List</a>
 * <p>
 * Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.
 * <p>
 * After doing so, return the head of the final linked list.  You may return any such answer.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The given linked list will contain between 1 and 1000 nodes.</li>
 *  <li>Each node in the linked list has -1000 <= node.val <= 1000.</li>
 * </ul>
 */
public interface RemoveZeroSumConsecutiveNodesFromLinkedList {

    ListNode removeZeroSumSublists(ListNode head);

    class RemoveZeroSumConsecutiveNodesFromLinkedListRev1 implements RemoveZeroSumConsecutiveNodesFromLinkedList {

        @Override
        public ListNode removeZeroSumSublists(ListNode head) {
            Deque<Integer> nums = new ArrayDeque<>();
            Set<Integer> seenPrefixSums = new HashSet<>();
            seenPrefixSums.add(0);

            int prefixSum = 0;
            ListNode curr = head;
            while (curr != null) {
                nums.offerLast(curr.val);
                prefixSum += curr.val;
                if (!seenPrefixSums.contains(prefixSum)) {
                    seenPrefixSums.add(prefixSum);
                } else {
                    int targetPrefixSum = prefixSum;
                    prefixSum -= nums.pollLast();
                    while (prefixSum != targetPrefixSum) {
                        seenPrefixSums.remove(prefixSum);
                        prefixSum -= nums.pollLast();
                    }
                }
                curr = curr.next;
            }

            ListNode dummy = new ListNode(42);
            curr = dummy;
            while (!nums.isEmpty()) {
                curr.next = new ListNode(nums.pollFirst());
                curr = curr.next;
            }
            return dummy.next;
        }
    }
}
