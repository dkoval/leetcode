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
            int n = 0;
            List<Integer> values = new ArrayList<>();
            ListNode curr = head;
            while (curr != null) {
                n++;
                values.add(curr.val);
                curr = curr.next;
            }

            int ans = -1;
            for (int i = 0; i < n / 2; i++) {
                int sum = values.get(i) + values.get(n - i - 1);
                ans = Math.max(ans, sum);
            }
            return ans;
        }
    }

    // O(N) time | O(1) space
    class MaximumTwinSumOfLinkedListByReversingSecondHalf implements MaximumTwinSumOfLinkedList {

        @Override
        public int pairSum(ListNode head) {
            ListNode prev = null;
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                prev = slow;
                slow = slow.next;
            }

            // 1st half of the list
            fast = head;
            prev.next = null;

            // 2nd half of the list
            slow = reverse(slow);
            int ans = -1;

            while (fast != null) {
                ans = Math.max(ans, fast.val + slow.val);
                fast = fast.next;
                slow = slow.next;
            }
            return ans;
        }

        private ListNode reverse(ListNode start) {
            ListNode prev = null;
            ListNode curr = start;
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
