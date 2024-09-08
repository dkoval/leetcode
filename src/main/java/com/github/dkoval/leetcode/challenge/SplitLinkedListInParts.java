package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/problems/split-linked-list-in-parts/description/">Split Linked List in Parts</a>
 * <p>
 * Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.
 * <p>
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than one.
 * This may lead to some parts being null.
 * <p>
 * The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size
 * greater than or equal to parts occurring later.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the list is in the range [0, 1000]</li>
 *  <li>0 <= Node.val <= 1000</li>
 *  <li>1 <= k <= 50</li>
 * </ul>
 */
public interface SplitLinkedListInParts {

    ListNode[] splitListToParts(ListNode head, int k);

    // O(N) time | O(1) extra space
    class SplitLinkedListInPartsRev1 implements SplitLinkedListInParts {

        @Override
        public ListNode[] splitListToParts(ListNode head, int k) {
            int n = size(head);
            int bucketSize = n / k;
            int numBucketsWithExtraElement = n % k;
            int numEqualBuckets = k - numBucketsWithExtraElement;

            ListNode[] result = new ListNode[k];
            ListNode curr = splitIntoBuckets(head, result, 0, numBucketsWithExtraElement, bucketSize + 1);
            splitIntoBuckets(curr, result, numBucketsWithExtraElement, numEqualBuckets, bucketSize);
            return result;
        }

        private int size(ListNode head) {
            int size = 0;
            ListNode curr = head;
            while (curr != null) {
                size++;
                curr = curr.next;
            }
            return size;
        }

        private ListNode splitIntoBuckets(ListNode from, ListNode[] result, int fromIdx, int numBuckets, int bucketSize) {
            ListNode curr = from;
            int i = fromIdx;
            while (numBuckets-- > 0) {
                ListNode[] bucket = split(curr, bucketSize);
                result[i++] = bucket[0];
                curr = bucket[1];
            }
            return curr;
        }

        // ListNode[0] - start of the current bucket
        // ListNode[1] - start of the next bucket
        private ListNode[] split(ListNode from, int size) {
            ListNode curr = from;
            ListNode prev = null;
            while (curr != null && size-- > 0) {
                prev = curr;
                curr = curr.next;
            }

            if (prev != null) {
                prev.next = null;
            }
            return new ListNode[]{from, curr};
        }
    }

    class SplitLinkedListInPartsRev2 implements SplitLinkedListInParts {

        @Override
        public ListNode[] splitListToParts(ListNode head, int k) {
            ListNode[] ans = new ListNode[k];

            int count = length(head);
            int parts = k;
            ListNode curr = head;
            int i = 0;
            while (count > 0) {
                ans[i++] = curr;

                // round_up(x / y) = (x + y - 1) / y = (x - 1) / y + 1
                int size = (count % parts == 0) ? count / parts : (count - 1) / parts + 1;
                count -= size;
                parts--;

                // skip (size - 1) nodes
                while (size-- > 1) {
                    curr = curr.next;
                }

                ListNode next = curr.next;
                curr.next = null;
                curr = next;
            }
            return ans;
        }

        private int length(ListNode head) {
            int length = 0;
            ListNode curr = head;
            while (curr != null) {
                length++;
                curr = curr.next;
            }
            return length;
        }
    }

    class SplitLinkedListInPartsRev3 implements SplitLinkedListInParts {

        @Override
        public ListNode[] splitListToParts(ListNode head, int k) {
            int length = length(head);

            int index = 0;
            int remaining = length % k;
            ListNode[] ans = new ListNode[k];
            ListNode curr = head;
            ListNode prev = null;
            while (curr != null) {
                // form a partition of size = length / k
                ListNode start = curr;
                int repeat = length / k;

                // check if there's an extra item to be added to the current partition
                if (remaining > 0) {
                    repeat++;
                    remaining--;
                }

                // accumulate items belonging to the current partition
                while (repeat-- > 0) {
                    prev = curr;
                    curr = curr.next;
                }
                if (prev != null) {
                    prev.next = null;
                }
                ans[index++] = start;
            }
            return ans;
        }

        private int length(ListNode head) {
            int length = 0;
            while (head != null) {
                length++;
                head = head.next;
            }
            return length;
        }
    }
}
