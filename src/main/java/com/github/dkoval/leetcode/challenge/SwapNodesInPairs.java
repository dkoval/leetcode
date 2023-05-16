package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/problems/swap-nodes-in-pairs/">Swap Nodes in Pairs</a>
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes. Only nodes itself may be changed.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the list is in the range [0, 100].</li>
 *  <li>0 <= Node.val <= 100</li>
 * </ul>
 */
public interface SwapNodesInPairs {

    ListNode swapPairs(ListNode head);

    // Resource: https://www.youtube.com/watch?v=o811TZLAWOo
    class SwapNodesInPairsUsingDummyNode implements SwapNodesInPairs {

        // O(N) time | O(1) space
        @Override
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(-1, head);
            ListNode prev = dummy;
            ListNode curr = head;

            // make sure we have at lest 2 nodes to work with
            while (curr != null && curr.next != null) {
                // save pointers that are going to be altered
                ListNode next = curr.next;
                ListNode tail = next.next;

                // Before: D -> 1 -> 2 | -> 3 -> 4 | -> ...
                //         ^    ^    ^
                //       prev curr next
                // ---
                // After:  D -> 2 -> 1 | -> 3 -> 4 | -> ...
                //                   ^      ^
                //                 prev    curr

                // reverse (curr, next) pair of nodes
                next.next = curr;
                curr.next = tail;

                // connect previous pair
                prev.next = next;

                // prepare for the next iteration
                prev = curr;
                curr = tail;
            }
            return dummy.next;
        }
    }

    class SwapNodesInPairsHandlingEdgeCases implements SwapNodesInPairs {

        // O(N) time | O(1) space
        @Override
        public ListNode swapPairs(ListNode head) {
            // len(list) <= 1
            if (head == null || head.next == null) {
                return head;
            }

            // len(list) >= 2
            ListNode prev = null;
            ListNode curr = head;

            // 2nd node is going to be the head of the modified list
            head = head.next;

            // make sure we have at least 2 nodes to work with
            while (curr != null && curr.next != null) {
                // save pointers that are going to be updated
                ListNode next = curr.next;
                ListNode tail = next.next;

                // reverse (curr, next) pair of nodes
                next.next = curr;
                curr.next = tail;

                // connect previous pair
                if (prev != null) {
                    prev.next = next;
                }

                // prepare for the next iteration
                prev = curr;
                curr = tail;
            }
            return head;
        }
    }
}
