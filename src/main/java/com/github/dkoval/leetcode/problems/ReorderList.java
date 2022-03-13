package com.github.dkoval.leetcode.problems;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/problems/reorder-list/">Reorder List</a>
 * <p>
 * You are given the head of a singly linked-list. The list can be represented as:
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the list is in the range [1, 5 * 10^4]</li>
 *  <li>1 <= Node.val <= 1000</li>
 * </ul>
 */
public interface ReorderList {

    void reorderList(ListNode head);

    // O(N) time | O(1) space
    class ReorderListUsingFastAndSlowPointers implements ReorderList {

        @Override
        public void reorderList(ListNode head) {
            // split the list into 2 halves
            ListNode first = head;
            ListNode second = head;
            while (second != null && second.next != null) {
                first = first.next;
                second = second.next.next;
            }

            second = first.next;
            first.next = null;

            // reverse the 2nd half
            ListNode prev = null;
            while (second != null) {
                ListNode next = second.next;
                second.next = prev;
                prev = second;
                second = next;
            }

            // reorder the list
            first = head;
            second = prev;
            ListNode last = null;
            while (first != null && second != null) {
                ListNode next1 = first.next;
                ListNode next2 = second.next;

                first.next = second;
                if (last != null) {
                    last.next = first;
                }

                last = second;
                first = next1;
                second = next2;
            }

            if (last != null && first != null) {
                last.next = first;
            }
        }
    }

    // O(N) time | O(1) space
    class ReorderListByCalculatingNumberPairsToConnect implements ReorderList {

        @Override
        public void reorderList(ListNode head) {
            int size = size(head);
            if (size < 3) {
                return;
            }

            // calculate the number of pairs to connect
            int numPairs = (size % 2 == 0 ? size - 2 : size) / 2;

            // split the input list into 3 disconnected ones:
            // L1 | MID | L2, where
            // size(L1) = size(L2) = numPairs,
            // size(MID) = 1, if size of the input list is odd, or 2 otherwise
            ListNode curr1 = head;
            while (numPairs-- > 1) {
                curr1 = curr1.next;
            }

            ListNode mid = curr1.next;
            curr1.next = null;
            curr1 = head;

            ListNode curr2;
            if (size % 2 == 0) {
                curr2 = mid.next.next;
                mid.next.next = null;
            } else {
                curr2 = mid.next;
                mid.next = null;
            }

            // connect(L1, L2) -> MID
            curr2 = reverse(curr2);
            ListNode last = connect(curr1, curr2);
            last.next = mid;
        }

        private int size(ListNode head) {
            ListNode curr = head;
            int size = 0;
            while (curr != null) {
                size++;
                curr = curr.next;
            }
            return size;
        }

        private ListNode reverse(ListNode head) {
            ListNode curr = head;
            ListNode prev = null;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }

        private ListNode connect(ListNode head1, ListNode head2) {
            ListNode curr1 = head1;
            ListNode curr2 = head2;
            ListNode prev = null;
            while (curr1 != null) {
                ListNode next1 = curr1.next;
                curr1.next = curr2;
                if (prev != null) {
                    prev.next = curr1;
                }
                prev = curr2;
                curr1 = next1;
                curr2 = curr2.next;
            }
            return prev;
        }
    }
}
