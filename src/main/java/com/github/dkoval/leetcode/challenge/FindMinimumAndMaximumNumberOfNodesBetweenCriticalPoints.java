package com.github.dkoval.leetcode.challenge;

import com.github.dkoval.leetcode.ListNode;

/**
 * <a href="https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/">Find the Minimum and Maximum Number of Nodes Between Critical Points</a>
 * <p>
 * A critical point in a linked list is defined as either a local maxima or a local minima.
 * <p>
 * A node is a local maxima if the current node has a value strictly greater than the previous node and the next node.
 * <p>
 * A node is a local minima if the current node has a value strictly smaller than the previous node and the next node.
 * <p>
 * Note that a node can only be a local maxima/minima if there exists both a previous node and a next node.
 * <p>
 * Given a linked list head, return an array of length 2 containing [minDistance, maxDistance] where
 * minDistance is the minimum distance between any two distinct critical points and
 * maxDistance is the maximum distance between any two distinct critical points.
 * <p>
 * If there are fewer than two critical points, return [-1, -1].
 * <p>
 * Constraints:
 * <ul>
 *  <li>The number of nodes in the list is in the range [2, 10^5]</li>
 *  <li>1 <= Node.val <= 10^5</li>
 * </ul>
 */
public interface FindMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {

    int[] nodesBetweenCriticalPoints(ListNode head);

    class FindMinimumAndMaximumNumberOfNodesBetweenCriticalPointsRev1 implements FindMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {

        @Override
        public int[] nodesBetweenCriticalPoints(ListNode head) {
            int[] ans = {Integer.MAX_VALUE, Integer.MIN_VALUE};
            ListNode curr = head;
            ListNode prev = null;
            int pos = 0;
            int first = -1;
            int last = -1;
            while (curr != null && curr.next != null) {
                pos++;
                if (prev != null && isCriticalPoint(prev.val, curr.val, curr.next.val)) {
                    if (first == -1) {
                        first = pos;
                    }

                    // minimize distance between critical points
                    if (last != -1) {
                        ans[0] = Math.min(ans[0], pos - last);
                    }

                    // maximize distance between critical points
                    if (pos != first) {
                        ans[1] = Math.max(ans[1], pos - first);
                    }

                    last = pos;
                }
                prev = curr;
                curr = curr.next;
            }

            if (ans[0] == Integer.MAX_VALUE || ans[1] == Integer.MIN_VALUE) {
                ans[0] = -1;
                ans[1] = -1;
            }
            return ans;
        }

        private boolean isCriticalPoint(int prev, int curr, int next) {
            return (curr < prev && curr < next) || (curr > prev && curr > next);
        }
    }
}
