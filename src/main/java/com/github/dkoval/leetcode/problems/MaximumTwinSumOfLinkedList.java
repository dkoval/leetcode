package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/">Maximum Twin Sum of a Linked List</a>
 * <p>
 * In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the
 * (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
 * <p>
 * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
 * The twin sum is defined as the sum of a node and its twin.
 * <p>
 * Given the head of a linked list with even length, return the maximum twin sum of the linked list.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the list is an even integer in the range [2, 10^5]</li>
 *  <li>1 <= Node.val <= 10^5</li>
 * </ul>
 */
public interface MaximumTwinSumOfLinkedList {

    int pairSum(ListNode head);

    // O(N) time | O(N) space
    class MaximumTwinSumOfLinkedListUsingExtraSpace implements MaximumTwinSumOfLinkedList {

        @Override
        public int pairSum(ListNode head) {
            List<Integer> values = new ArrayList<>();
            ListNode curr = head;
            while (curr != null) {
                values.add(curr.val);
                curr = curr.next;
            }

            int best = 0;
            int n = values.size();
            for (int i = 0; i < n / 2; i++) {
                int sum = values.get(i) + values.get(n - i - 1);
                best = Math.max(best, sum);
            }
            return best;
        }
    }

    // O(N) time | O(1) space
    class MaximumTwinSumOfLinkedListByReversingSecondHalf implements MaximumTwinSumOfLinkedList {

        @Override
        public int pairSum(ListNode head) {
            // split the list into 2 halves
            // n >= 2
            ListNode slow = head;
            ListNode fast = head.next.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            fast = slow.next; // points to the head node of the 2nd half
            slow.next = null;
            slow = head;      // points to the head node of the 1st half

            fast = reverse(fast);

            int best = 0;
            while (slow != null) {
                best = Math.max(best, slow.val + fast.val);
                slow = slow.next;
                fast = fast.next;
            }
            return best;
        }

        private ListNode reverse(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
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
