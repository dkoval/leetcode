package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/640/week-5-september-29th-september-30th/3992/">Split Linked List in Parts</a>
 * <p>
 * Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.
 * <p>
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than one.
 * This may lead to some parts being null.
 * <p>
 * The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have
 * a size greater than or equal to parts occurring later.
 * <p>
 * Return an array of the k parts.
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the list is in the range [0, 1000]</li>
 *  <li>0 <= Node.val <= 1000</li>
 *  <li>1 <= k <= 50</li>
 * </ul>
 */
public class SplitLinkedListInParts {

    // O(N) time | O(1) extra space
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
